DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

CREATE TABLE product
(
    id   bigserial   NOT NULL PRIMARY KEY,
    name VARCHAR(45) NULL
);

CREATE TABLE employee
(
    id      bigserial   NOT NULL PRIMARY KEY,
    name    VARCHAR(45) NULL,
    address VARCHAR(70) NULL
);