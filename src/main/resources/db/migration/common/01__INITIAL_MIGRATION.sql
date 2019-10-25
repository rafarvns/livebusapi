--liquibase formatted sql

--changeset apilivebus:1

CREATE TABLE auth (
    id INT (11) NOT NULL AUTO_INCREMENT,
    username VARCHAR (16) NOT NULL,
    password VARCHAR (24) NOT NULL,
    CONSTRAINT auth_pk PRIMARY KEY (id)
);