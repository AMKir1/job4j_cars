create table roles (
    id serial primary key,
    name varchar(1000)
);

create table users (
        id serial primary key,
        name varchar(2000),
        id_role int not null unique references roles(id)
);

create table ads (
        id serial primary key,
        desc varchar(20000),
        brand varchar(1000),
        type varchar(1000),
        pic varchar(1000),
        sold boolean,
        id_user int not null unique references users(id)
);