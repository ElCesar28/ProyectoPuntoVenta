create database PuntoVenta;
use puntoVenta;

create table Cliente (
	idCliente int not null auto_increment primary key,
    nombre varchar(45) not null,
    apellidos varchar(45) not null,
    direccion varchar(50) not null,
    telefono1 varchar(20) not null,
    telefono2 varchar(20) null
);

create table Empleado(
	idEmpleado int not null auto_increment primary key,
    user varchar(15) not null,
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
	idVenta int not null auto_increment primary key,
    fecha datetime not null,
    total decimal(10,2) not null,
    idCliente int not null,
    idEmpleado int not null,
    constraint foreign key (idCliente) references Cliente (idCliente), 
    constraint foreign key (idEmpleado) references Empleado (idEmpleado) 
);

create table Proveedor (
	idProveedor int not null auto_increment primary key,
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

use puntoventa;

insert into marca values(null,'Mabe');
insert into marca values(null,'Whirlpool');
insert into marca values(null,'Across');

select * from marca;

create table Categoria(
	idCategoria int not null auto_increment primary key,
    nombre varchar(20) not null
);
create table Producto(
	idProducto varchar(35) not null primary key,
    descripcion varchar(70) not null,
    stock tinyint not null,
    precio decimal(10,2) not null,
    idMarca int not null,
    idCategoria int not null,
    idProveedor int not null,
    constraint foreign key (idMarca) references Marca (idMarca),
    constraint foreign key (idCategoria) references Categoria(idCategoria),
    constraint foreign key (idProveedor) references Proveedor(idProveedor)
);
 create table DetalleDeVenta(
	idProducto varchar(35) not null,
    idVenta int not null,
    cantidad tinyint not null,
    precio decimal (10,2) not null,
    descuento float not null,
    primary key(idProducto,idVenta),
    constraint foreign key (idProducto) references Producto(idProducto),
    constraint foreign key (idVenta) references Venta(idVenta)
 );

