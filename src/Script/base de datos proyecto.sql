-- ---------------------------------------------- DATABASE ----------------------------------------------
drop database if exists PuntoVenta;
create database PuntoVenta;
use puntoVenta;

-- ---------------------------------------------- TABLES ----------------------------------------------
create table Cliente (
	idCliente int unsigned not null auto_increment primary key,
    nombre varchar(45) not null,
    apellidos varchar(45) not null,
    direccion varchar(50) not null,     
    telefono1 varchar(20) not null,
    telefono2 varchar(20) null,
    tipo enum('Tecnico','Publico') not null
);

create table Empleado(
	idEmpleado int unsigned not null auto_increment primary key,
    user varchar(15) not null unique,
    password varchar(40) not null,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    correo varchar(45) not null,
    telefono1 varchar(20) not null,
    telefono2 varchar(20) null,
    rol enum('administrador','empleado') not null,
    direccion varchar(50) not null
);

create table Venta(
	idVenta int unsigned not null auto_increment primary key,
    fecha datetime not null,
    total decimal(10,2) not null,
    estado enum('pagada','porCobrar','cancelada'),
    idCliente int unsigned not null,
    idEmpleado int unsigned not null,
    constraint foreign key (idCliente) references Cliente (idCliente), 
    constraint foreign key (idEmpleado) references Empleado (idEmpleado) 
);

create table Proveedor (
	idProveedor int unsigned not null auto_increment primary key,
    nombre varchar(30) not null,
    numCuenta1 text not null,
    numCuenta2 text null,
    correo1 varchar(45) not null,
    correo2 varchar(45) null,
    telefono1 varchar(20) not null,
    telefono2 varchar(20) null
);

create table Marca(
	idMarca int not null auto_increment primary key,
    nombre varchar(20) not null
);

create table Categoria(
	idCategoria int not null auto_increment primary key,
    nombre varchar(20) not null
);

create table Producto(
	idProducto varchar(35) not null primary key,
    descripcion varchar(100) not null,
    descripcionCorta varchar(50)not null,
    stock int unsigned not null,
    precioPublico decimal(10,2) not null,
    precioTaller decimal(10,2) not null,
    idMarca int not null,
    idCategoria int not null,
    idProveedor int unsigned not null,
    constraint foreign key (idMarca) references Marca (idMarca),
    constraint foreign key (idCategoria) references Categoria(idCategoria),
    constraint foreign key (idProveedor) references Proveedor(idProveedor)
);
 create table DetalleDeVenta(
	idProducto varchar(35) not null,
    idVenta int unsigned not null,
    cantidad tinyint not null,
	precio decimal(10,2) not null,
    descuento float not null,
    primary key(idProducto,idVenta),
    constraint foreign key (idProducto) references Producto(idProducto),
    constraint foreign key (idVenta) references Venta(idVenta)
 );
 
 -- ---------------------------------------------- TESTDAT ----------------------------------------------
INSERT INTO `categoria` VALUES (null,'Lavadoras')
							  ,(null,'Refrigeradores')
                              ,(null,'Secadoras')
                              ,(null,'Estufas');

INSERT INTO `cliente` VALUES (null,'Tecnico','General','---------------','0000000000','','tecnico')
							,(null,'Publico','General','---------------','0000000000','','publico');

INSERT INTO `empleado` VALUES (null,'admin',sha1('admin'),'César Antonio','Navarro Sosa','cesaaar26@gmail.com','4451455052','','administrador','Ponciano Vega #670');

INSERT INTO `marca` VALUES (null,'Mabe')
						  ,(null,'Whirlpool')
                          ,(null,'Across')
                          ,(null,'Maytag')
                          ,(null,'Excel')
                          ,(null,'Koblenz');

INSERT INTO `proveedor` VALUES (null,'llyrsa','459459459','','llirsa1@gmail.com','','12345656543','')
							  ,(null,'Ryse','459459459','','ryse1@gmail.com','ryse2@gmail.com','45556772829','')
							  ,(null,'Frilav','459459459','','correo1@gmail.com','correo2@gmail.com','111111111','222222222');
                              
INSERT INTO `producto` VALUES ('189D1903P001','Rotula superior Oly','Rotula Olympia',20,25.00,(25.00-(25.00*0.10)),1,1,2)
							 ,('W10530058','Thermostato p/refrigerador','Thermostato Mabe',5,239,(239-(239*0.10)),2,2,3);   
-- ---------------------------------------------- StorageProcedures ----------------------------------------------
-- Insertamos los productos de la vnta en la tabla detalle de venta
DELIMITER $$
DROP PROCEDURE IF EXISTS insertarDetalleVenta$$
CREATE PROCEDURE insertarDetalleVenta(
	in idp varchar(35),
    in idv int,
    in cantida int,
    in preci decimal(10,2),
    in descuent float)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
	-- ERROR, WARNING
	ROLLBACK;
END;
	START TRANSACTION;
	insert into detalledeventa values(idp,idv,cantida,preci,descuent);
    update producto set descripcion=descripcion,
						stock=(stock-cantida),
                        precioPublico=precioPublico,
                        precioTaller=precioTaller,
                        idmarca=idmarca,
                        idcategoria=idcategoria,
                        idproveedor=idproveedor where idProducto=idp;
                        
	COMMIT;
END
$$
DELIMITER ;

-- Realiza una cosulta en la tabla detalledeventa para conocer los productos que se han vendido, por categoria
DELIMITER $$
DROP PROCEDURE IF EXISTS prodxcat$$
CREATE PROCEDURE prodxcat (clave int, fechain datetime, fechafin datetime)
BEGIN
	select p.idproducto, p.descripcion, p.precio, p.stock, c.nombre,
		(	
			select  sum(d.cantidad) from detalledeventa d  where d.idproducto = p.idproducto
		) as ProductoVendido,
		(
			select sum(ProductoVendido*d.precio) from detalledeventa d join venta v 
			on d.idventa= v.idventa 
			where d.idproducto=p.idproducto and v.fecha between fechain and fechafin 
		) as MontoProducto
		
	from producto p join categoria c 
	on p.idcategoria = c.idcategoria
	where c.idcategoria=clave ;
END 
$$
DELIMITER ;

-- Obtenemos una lista de las ventas en un rago de fechas
DELIMITER $$
DROP PROCEDURE IF EXISTS lista$$
CREATE PROCEDURE Lista(fechaInicial datetime, fechaFinal datetime)
BEGIN
	select v.idventa
         , v.fecha
         , v.total
         , concat(e.nombre," ",e.apellido) 
	from venta v 
	join empleado e where e.idempleado = v.idempleado and v.fecha between fechaInicial and fechaFinal
	order by v.fecha desc; 
END
$$  
DELIMITER ;

-- Obtenemos un reporte de ventas, detalles de venta y productos de la fecha proporcionada
DELIMITER $$
DROP PROCEDURE IF EXISTS reporteDia $$
CREATE PROCEDURE reporteDia(fechaDelDia DATETIME)
BEGIN
	SELECT v.idventa AS ID
		 , v.fecha AS Fecha 
		 , p.idProducto AS IDProducto
		 , p.descripcion AS Descripcion
		 , ddv.cantidad AS Cantidad
		 , (SELECT c.tipo FROM cliente c WHERE c.idCliente=v.idCliente) AS Tipo
		 , ddv.precio AS Precio
		 , (ddv.cantidad*ddv.precio) AS Importe
		 , (SELECT concat(e.nombre, " ", e.apellido) FROM empleado e WHERE e.idEmpleado=v.idEmpleado ) AS Empleado
		 , (SELECT concat(c.nombre," ",c.apellidos) FROM cliente c WHERE c.idCliente=v.idCliente) AS Cliente	
	FROM venta v JOIN detalledeventa ddv JOIN producto p
	ON v.idVenta = ddv.idVenta AND ddv.productid=p.productid
	where date(v.fecha)=fechaDelDia;
END$$
DELIMITER ;




