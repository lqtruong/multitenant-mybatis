use `ufo`; #super admin to manage site admin
create table if not exists `users`(
    `id`            integer primary key auto_increment,
    `username`      varchar(100) not null,
    `email`         varchar(100) not null,
    `tenant`        varchar(20) not null,
    `createdAt`     datetime not null default current_timestamp,
    `modifiedAt`    datetime not null default current_timestamp
);

insert into `users`
(
    id, email, username, tenant, createdAt, modifiedAt
) values
(1, 'truong@mail.com', 'truong', 'ufo', sysdate(), sysdate())
;

####################################################################

use `vn`; #vietnam site
create table if not exists `users`(
    `id`            integer primary key auto_increment,
    `username`      varchar(100) not null,
    `email`         varchar(100) not null,
    `tenant`        varchar(20) not null,
    `createdAt`     datetime not null default current_timestamp,
    `modifiedAt`    datetime not null default current_timestamp
);

insert into `users`
(
    id, email, username, tenant, createdAt, modifiedAt
) values
(1, 'truong@mail.com', 'truong', 'vn', sysdate(), sysdate())
;

####################################################################
use `tr`; #turkey site
create table if not exists `users`(
    `id`            integer primary key auto_increment,
    `username`      varchar(100) not null,
    `email`         varchar(100) not null,
    `tenant`        varchar(20) not null,
    `createdAt`     datetime not null default current_timestamp,
    `modifiedAt`    datetime not null default current_timestamp
);

insert into `users`
(
    id, email, username, tenant, createdAt, modifiedAt
) values
(2, 'charles@mail.com', 'charles', 'tr', sysdate(), sysdate())
;

####################################################################
use `ind`; #indonesia site
create table if not exists `users`(
    `id`            integer primary key auto_increment,
    `username`      varchar(100) not null,
    `email`         varchar(100) not null,
    `tenant`        varchar(20) not null,
    `createdAt`     datetime not null default current_timestamp,
    `modifiedAt`    datetime not null default current_timestamp
);

insert into `users`
(
    id, email, username, tenant, createdAt, modifiedAt
) values
(3, 'indos@mail.com', 'indos', 'ind', sysdate(), sysdate())
;

### aggregate in multiple schemas
select * from `vn`.`users` union all select * from `tr`.`users` union all select * from `ind`.`users`;