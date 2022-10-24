--sentencia para precargar:

drop table if exists medicamentos, create table medicamentos ( --if not exists
    id int primary key, --auto_increment-- , borramos eso a ver si sale
    codigo_numerico int,
    nombre varchar(255),
    laboratorio varchar (255),
    cantidad int,
    precio int);