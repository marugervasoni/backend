create table if not exists farmacia (
    id int auto_increment primary key,
    codigo_numerico int,
    nombre varchar(255),
    laboratorio varchar (255),
    cantidad int,
    precio int);

-- Pueden agregar acá sentencias Insert para precargar datos.