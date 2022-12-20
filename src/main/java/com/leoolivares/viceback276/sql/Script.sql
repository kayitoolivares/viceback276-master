



create database vice_prueba_leo

use vice_prueba_leo

create table producto(
id int auto_increment primary key,
nombbre varchar(100),
cantidad float,
precio float,
estatus BOOLEAN
)

create table cliente(
id int auto_increment primary key,
nombre varchar(100),
estatus BOOLEAN
)

create table usuario(
id int auto_increment primary key,
nombre varchar(100),
estatus BOOLEAN
)

create table factura(
id int auto_increment primary key,
id_cliente int,
id_usuario int,
fecha datetime,
estatus varchar(10),
CONSTRAINT  FOREIGN KEY fk_factura_cliente (id_cliente) REFERENCES  cliente(id),
CONSTRAINT FOREIGN KEY  fk_factura_usuario (id_usuario) REFERENCES  usuario(id)
)


create table facturadetalle(
id int auto_increment primary key,
id_factura int,
id_producto int,
cantidad float,
precio float,
CONSTRAINT  FOREIGN KEY fk_facturadetalle_factura (id_factura) REFERENCES factura(id),
CONSTRAINT  FOREIGN KEY fk_facturadetalle_producto (id_producto) REFERENCES producto(id)
)


