create table users
(
    user_id    serial
        constraint users_pk
            primary key,
    login      varchar(100) not null,
    first_name varchar(100) not null,
    last_name  varchar(100) not null
);

insert into users(login, first_name, last_name)
VALUES ('username', 'name', 'surname'),
       ('ln', 'Lando', 'Norris'),
       ('Lewis44', 'Lewis', 'Hamilton');