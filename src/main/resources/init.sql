DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    id   SERIAL      NOT NULL PRIMARY KEY,
    name VARCHAR(45) NULL
);

DROP TABLE IF EXISTS employee CASCADE;
CREATE TABLE employee
(
    id      SERIAL      NOT NULL PRIMARY KEY,
    name    VARCHAR(45) NULL,
    address VARCHAR(70) NULL
);

INSERT INTO product(name)
VALUES ('Beer'),
       ('Wine');

INSERT INTO employee(name, address)
VALUES ('Vladimir', 'Sadovaya 34');