drop database if exists PuntoVenta;
create database PuntoVenta;
use puntoVenta;

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
    descripcion varchar(70) not null,
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
 
INSERT INTO `categoria` VALUES (null,'Lavadoras'),(null,'Refrigeradores'),(null,'Ollas de presion'),(null,'Estufas');
INSERT INTO `cliente` VALUES (null,'Tecnico','General','---------------','0000000000','','tecnico'),(null,'Publico','General','---------------','0000000000','','publico');
INSERT INTO `empleado` VALUES (null,'admin',sha1('admin'),'César Antonio','Navarro Sosa','cesaaar26@gmail.com','4451455052','','administrador','Ponciano Vega #670');
INSERT INTO `marca` VALUES (null,'Mabe'),(null,'Whirlpool'),(null,'Across'),(null,'Maytag'),(null,'Excel'),(null,'Koblenz');
INSERT INTO `proveedor` VALUES (null,'llyrsa','459459459','','llirsa1@gmail.com','','12345656543','')
								,(null,'Ryse','459459459','','ryse1@gmail.com','ryse2@gmail.com','45556772829','')
                                ,(null,'Frilav','459459459','','correo1@gmail.com','correo2@gmail.com','111111111','222222222');
INSERT INTO `producto` VALUES ('189DG001','Lining ',3,536.00,(536.00-(536*0.10)),2,1,1),('189DG002','Banda Maytag',6,200.00,(200.00-(200*0.10)),4,1,1)
,('189DG005','Flecha de lavado con engrane',3,457.80,(457.80-(457.80*0.10)),2,1,1),('189DG008','Sello tina Olympia',15,45.50,(45.50-(45.50*0.10)),1,1,1)
,('189DG010','Navaja Oster original reversible',10,165.00,(165.0-(165.0*0.10)),2,1,1);   

DELIMITER $$
drop procedure if exists insertarDetalleVenta$$
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


delimiter $$
drop procedure if exists prodxcat$$
create procedure prodxcat (clave int, fechain datetime, fechafin datetime)
begin
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
end $$
delimiter ;

delimiter $$
drop procedure if exists lista$$
CREATE PROCEDURE Lista(fechaInicial datetime, fechaFinal datetime)
BEGIN
select v.idventa, v.fecha, v.total, concat(e.nombre," ",e.apellido) from venta v 
join empleado e where e.idempleado = v.idempleado and v.fecha between fechaInicial and fechaFinal
order by v.fecha desc; 
END$$
delimiter ;

