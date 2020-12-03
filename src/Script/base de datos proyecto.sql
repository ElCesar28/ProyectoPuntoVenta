drop database puntoventa;
create database PuntoVenta;
use puntoVenta;

create table Cliente (
	idCliente int unsigned not null auto_increment primary key,
    nombre varchar(45) not null,
    apellidos varchar(45) not null,
    direccion varchar(50) not null,
    telefono1 varchar(20) not null,
    telefono2 varchar(20) null
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
    numCuenta text not null,
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
    precio decimal(10,2) not null,
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
    precio decimal (10,2) not null,
    descuento float not null,
    primary key(idProducto,idVenta),
    constraint foreign key (idProducto) references Producto(idProducto),
    constraint foreign key (idVenta) references Venta(idVenta)
 );
 
INSERT INTO `categoria` VALUES (1,'Lavadoras'),(2,'Refrigeradores'),(3,'Ollas de presion'),(4,'Estufas');
INSERT INTO `cliente` VALUES (1,'Juan Jesus','Rocha Martinez','Contitucion #5','000999887755',''),(2,'Miguel','Chica Juarez','Maria Concepción zanches #12','445567765','0000000000'),(4,'Jose Juan','Zamudio','Avenida Puebla #5','4451455052','09999099909');
INSERT INTO `empleado` VALUES (3,'admin',sha1('admin'),'César Antonio','Navarro Sosa','cesaaar26@gmail.com','4451455052','','administrador','Ponciano Vega #670');
INSERT INTO `marca` VALUES (1,'Mabe'),(2,'Whirlpool'),(3,'Across'),(4,'Maytag'),(5,'Super Matic'),(6,'Koblenz');
INSERT INTO `proveedor` VALUES (null,'llyrsa',hex(aes_encrypt('459459459','p')),'llirsa1@gmail.com','','12345656543','')
								,(null,'Ryse',hex(aes_encrypt('987987987','p')),'ryse1@gmail.com','ryse2@gmail.com','45556772829','')
                                ,(null,'Frilav',hex(aes_encrypt('123123123','p')),'correo1@gmail.com','correo2@gmail.com','111111111','222222222');
INSERT INTO `producto` VALUES ('189DG001','Lining ',3,536.00,2,1,1),('189DG002','Banda Maytag',6,200.00,4,1,1),('189DG005','Flecha de lavado con engrane',3,457.80,2,1,1),('189DG008','Sello tina Olympia',15,45.50,1,1,1),('189DG010','Navaja Oster original reversible',10,165.00,2,1,1);


