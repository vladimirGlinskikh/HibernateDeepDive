DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    id   SERIAL      NOT NULL PRIMARY KEY,
    name VARCHAR(45) NULL
);

