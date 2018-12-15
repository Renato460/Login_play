# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aranceles (
  tipo_institucion              varchar(255),
  nombre_inst                   varchar(255),
  nombre_sede                   varchar(255),
  nombre_carrera                varchar(255),
  jornada                       varchar(255),
  version                       integer,
  arancel_anual                 integer,
  arancel_ref                   integer
);

create table user_model (
  pass                          varchar(255) not null,
  nombre                        varchar(255),
  apellidos                     varchar(255),
  mail                          varchar(255),
  fono                          varchar(255),
  direccion                     varchar(255),
  constraint pk_user_model primary key (pass)
);


# --- !Downs

drop table if exists aranceles;

drop table if exists user_model;

