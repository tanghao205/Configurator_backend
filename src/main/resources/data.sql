create schema if not exists public;

set schema public;

drop table if exists order_table cascade;
drop table if exists order_option cascade;
drop table if exists option cascade;
drop table if exists model cascade;

create table if not exists model (
                                     model_name varchar(100) primary key,
                                     actv_flg char(1) not null default 'Y',
                                     crt_ts timestamp null,
                                     crt_id varchar(30) null,
                                     upd_ts timestamp null,
                                     upd_id varchar(30) null
);

create table if not exists option (
                                      option varchar(255) primary key,
                                      model_name varchar(100),
                                      foreign key (model_name) references model(model_name),
                                      actv_flg char(1) not null default 'Y',
                                      crt_ts timestamp null,
                                      crt_id varchar(30) null,
                                      upd_ts timestamp null,
                                      upd_id varchar(30) null
);

create table order_table (
                             order_id int primary key auto_increment,
                             order_number varchar(30) not null,
                             option varchar(255),
                             foreign key (option) references option(option),
                             model_name varchar(100),
                             foreign key (model_name) references model(model_name),
                             actv_flg char(1) not null default 'Y',
                             crt_ts timestamp null,
                             crt_id varchar(30) null,
                             upd_ts timestamp null,
                             upd_id varchar(30) null
);

merge into model values
                      ('IronManCar', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                      ('BadmanMotor', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                      ('HulkTruck', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                      ('ThorHorse', 'Y', localtimestamp, 'system', localtimestamp, 'system');

merge into option values
                       ('Black', 'IronManCar', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                       ('Red', 'IronManCar', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                       ('Yellow', 'IronManCar', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                       ('Blue', 'HulkTruck', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                       ('Orange', 'ThorHorse', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                       ('Green', 'BadmanMotor', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                       ('Brown', 'ThorHorse', 'Y', localtimestamp, 'system', localtimestamp, 'system'),
                       ('White', 'ThorHorse', 'Y', localtimestamp, 'system', localtimestamp, 'system');

create table if not exists order_option(
    order_id int not null,
    option varchar(255) not null,
    primary key(order_id, option),
    foreign key (option) references option(option),
    foreign key (order_id) references order_table(order_id)
);
