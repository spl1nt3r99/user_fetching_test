create table user_table
(
    ldap_login serial
        constraint user_table_pk
            primary key,
    name       varchar(100) not null,
    surname    varchar(100) not null
);

insert into user_table(name, surname)
VALUES ('name', 'surname'),
       ('Charles', 'Leclerk'),
       ('Max', 'Verstappen');