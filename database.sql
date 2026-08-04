CREATE DATABASE preowned_merchandise;

USE preowned_merchandise;

CREATE TABLE users(

id INT PRIMARY KEY AUTO_INCREMENT,

name VARCHAR(100),

email VARCHAR(100) UNIQUE,

password VARCHAR(255),

phone VARCHAR(15),

role VARCHAR(20)

);

CREATE TABLE categories(

id INT PRIMARY KEY AUTO_INCREMENT,

category_name VARCHAR(50)

);

INSERT INTO categories(category_name)
VALUES

('Books'),

('Electronics'),

('Furniture'),

('Stationery'),

('Others');


CREATE TABLE products(

id INT PRIMARY KEY AUTO_INCREMENT,

product_name VARCHAR(100),

category_id INT,

description VARCHAR(500),

price DOUBLE,

image VARCHAR(255),

seller_email VARCHAR(100),

status VARCHAR(20),

FOREIGN KEY(category_id)
REFERENCES categories(id)

);


CREATE TABLE orders(

id INT PRIMARY KEY AUTO_INCREMENT,

buyer_email VARCHAR(100),

product_id INT,

order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,


FOREIGN KEY(product_id)
REFERENCES products(id)

);


CREATE TABLE admin(

id INT PRIMARY KEY AUTO_INCREMENT,

username VARCHAR(50),

password VARCHAR(100)

);