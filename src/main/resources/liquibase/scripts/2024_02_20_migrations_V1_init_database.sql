DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE product
(
    id   UUID DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
    name VARCHAR(45)                     NULL
);

CREATE TABLE employee
(
    id      UUID DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
    name    VARCHAR(45)                     NULL,
    address VARCHAR(70)                     NULL
);
