--liquibase formatted sql

--changeset apilivebus:100

INSERT INTO LINE (id, number, name) VALUES (1, 90, 'Linha 090');

INSERT INTO ROUTE_DRAW (latitude, longitude, index, line) VALUES (-10.180121, -48.333976, 1, 1);
INSERT INTO ROUTE_DRAW (latitude, longitude, index, line) VALUES (-10.180512, -48.333971, 1, 1);
INSERT INTO ROUTE_DRAW (latitude, longitude, index, line) VALUES (-10.180544, -48.335014, 1, 1);
INSERT INTO ROUTE_DRAW (latitude, longitude, index, line) VALUES (-10.180671, -48.336114, 1, 1);
INSERT INTO ROUTE_DRAW (latitude, longitude, index, line) VALUES (-10.180647, -48.336675, 1, 1);