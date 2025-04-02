use byqqq9dje1cnepsizgxe;

drop table if exists misionNinja;
drop table if exists habilidad;
drop table if exists ninja;
drop table if exists mision;

create table ninja(
	id int primary key auto_increment,
    nombre varchar(200),
    rango enum("Genin","Chunin","Jonin"),
    aldea varchar(200)
);
insert into ninja(nombre,rango,aldea) values 
("Naruto Uzumaki", "Jonin", "Aldea de la hoja"),
("Sasuke Uchiha", "Chunin", "Aldea de la hoja"),
("Kakashi Hatake", "Jonin", "Aldea de la hoja"),
("Nagato Uzumaki", "Genin", "Aldea de la lluvia"),
("Sakura Haruno", "Genin", "Aldea de la hoja"),
("Gaara", "Chunin", "Aldea de la arena");


create table mision(
	id int primary key auto_increment,
    descripcion varchar(200),
    rango enum ("Genin","Chunin","Jonin"),
    recompensa double
);

insert into mision(descripcion,rango,recompensa)values
("Escoltamiento a la tierra del fuego", "Chunin", 50),
("Encontrar gato desaparecido", "Genin", 10),
("Eliminar ninja perverso", "Jonin", 70),
("Recolectar información enemiga", "Genin", 30),
("Supervisar las entradas a la aldea", "Chunin", 40),
("Atacar ninjas enemigos", "Jonin", 45),
("Custodiar pergaminos de la aldea", "Chunin", 40),
("Limpiar paredes de la aldea", "Genin", 10);


 create table misionNinja(
	id_ninja int,
    id_mision int,
	estado enum("preparada", "activa", "finalizada"),
    fecha_inicio varchar(50),
    fecha_fin varchar(50),
    foreign key (id_ninja) references ninja(id),
	foreign key (id_mision) references mision(id)
 );
 
 insert into misionNinja(id_ninja,id_mision,estado,fecha_inicio,fecha_fin)values
(2, 1,"finalizada","2022-09-12", "2022-10-11"),
(4, 2, "finalizada","2022-07-02", "2022-07-02"),
(1, 3, "finalizada" ,"2022-08-20", "2022-12-20"),
(3, 4, "finalizada","2022-05-30", "2022-06-15"),
(null,3,"preparada", null, null),
(1, 5, "activa" ,"2022-08-20", null);

 

 create table habilidad(
	id_ninja int,
    nombre varchar(200),
    descripcion varchar(200),
    foreign key (id_ninja) references ninja(id)
 );
 
 insert into habilidad(id_ninja,nombre,descripcion) values
 (1, "Rasengan", "Hace rotar una gran cantidad de chakra en la mano para impactar al enemigo"),
 (1, "Clones de sombra", "Crea una gran cantidad de clones para usarlos en batalla"),
 (2, "Sharingan", "Puede predecir los movimientos del enemigo"),
 (2, "Amaterasu", "Llamas que arden hasta que desintegran su objetivo"),
 (3, "Sharingan", "Capacidad de copiar cualquier jutsu enemigo"),
 (4, "Shinra Tensei", "Permite repeler materia o técnicas a través de la fuerza repulsiva"),
 (5, "Super Fuerza", "Libera chakra en sus manos para potenciar su fuerza"),
 (6, "Defensa de Arena", "La arena en su espalda evita que sea lastimado");
 
 
select  n.nombre as ninja, h.nombre as habilidad, h.descripcion from habilidad h join ninja n on h.id_ninja = n.id;
select * from misionNinja;
update misionNinja set estado = "finalizada", fecha_fin = "2022-08-22" where id_mision = 5;
select * from mision m join ninja n on m.rango = n.rango where n.id = 2;

select m.id_mision, m.estado ,m.fecha_inicio, m.fecha_fin, mi.descripcion from misionNinja m  join mision mi on m.id_mision = mi.id where m.id_ninja = 1;