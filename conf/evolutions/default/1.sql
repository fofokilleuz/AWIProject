# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                            bigint not null,
  email                         varchar(255),
  firstname                     varchar(255),
  lastname                      varchar(255),
  password                      varchar(255),
  mobile                        varchar(255),
  address                       varchar(255),
  postal_code                   varchar(255),
  city                          varchar(255),
  name_profil_image             varchar(255),
  constraint pk_user primary key (id)
);
create sequence user_seq;


# --- !Downs

drop table if exists user;
drop sequence if exists user_seq;

