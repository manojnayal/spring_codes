
drop table person if exists;
create table person(
id integer not null,
name varchar(255) not null,
birth_date timestamp,
location varchar(255),
primary key(id)
);