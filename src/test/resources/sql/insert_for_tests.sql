DELETE FROM employee;
DELETE FROM product;

INSERT INTO employee(name, email)
VALUES ('Eugeny', 'eugeny@gmail.com'),
       ('Svetlana', 'svetlana@gmail.com');

INSERT INTO product(name, quantity)
VALUES ('laptop', 12),
       ('monitor', 20),
       ('mouse', 123);