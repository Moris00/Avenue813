
DROP DATABASE IF EXISTS Avenue813;

CREATE DATABASE Avenue813;

USE Avenue813;

drop user if exists 'ADMIN'@'localhost';  

create user 'ADMIN'@'localhost' identified by 'Avenue813';

GRANT ALL ON Avenue813.* to 'prop'@'localhost';

DROP TABLE IF EXISTS Customers ;

CREATE TABLE Customers(id VARCHAR(16) PRIMARY KEY NOT NULL, email VarChar(20) NOT NULL, passw VARCHAR(10) NOT NULL, full_name VARCHAR(16), address VARCHAR(20) NOT NULL, shippinh_address VARCHAR(20) NOT NULL , country varchar(10), phone varchar(10));

DROP TABLE IF EXISTS Categories ;

CREATE TABLE Categories( id VARCHAR(16) PRIMARY KEY NOT NULL, nome VARCHAR(16) NOT NULL, descrizione Varchar(10) );

DROP TABLE IF EXISTS Opzioni;

CREATE TABLE Opzioni (id VARCHAR(15) PRIMARY KEY NOT NULL, nome VARCHAR(16));

DROP TABLE IF EXISTS Product_Options ;

CREATE TABLE Product_Options(id VARCHAR(15) PRIMARY KEY NOT NULL, product_id CHAR(16) NOT NULL);

DROP TABLE IF EXISTS Product_Categories ;

CREATE TABLE Product_Categories (id VARCHAR(15) PRIMARY KEY NOT NULL, product_id CHAR(16) NOT NULL , category_id CHAR(16) NOT NULL);

DROP TABLE IF EXISTS Orders ;

CREATE TABLE Orders(id VARCHAR(15) PRIMARY KEY NOT NULL, customer_id VARCHAR(20) NOT NULL, ammount VARCHAR(10) NOT NULL, shipping_address VARCHAR(15), order_address VARCHAR(15), order_email VARCHAR(15) , order_date DATE , order_status varchar(15));

DROP TABLE IF EXISTS Products ;

CREATE TABLE Products( id VARCHAR(15) PRIMARY KEY NOT NULL ,  nome VARCHAR(15) , price Double, weight double, descrizione VARCAR(20), immagine , category VARCHAR(10),create_date DATE, stock varchar(5)) ;

DROP TABLE IF EXISTS Order_details;

CREATE TABLE Order_details(id VARCHAR(15) PRIMARY KEY NOT NULL, order_id varchar(10) NOT NULL ,product_id varchar(10),price Double , quantity int);


insert into Customers values ('AA0','primo@gmail.com','primo','Silvio Berlusconi','via mariscoli','via milano 19','Salerno','3456789821');
insert into Customers values ('AB0','secondo@gmail.com','secondo','Sergio Mattarella','via mariscoli','via giovani 20','Rocca','3455589821');
insert into Customers values ('AC0','terzo@gmail.com','terzo','Bruno Vespa','via mariscoli','via toraldo 56','Gioi','3471789821');
insert into Customers values ('AD0','quarto@gmail.com','quarto','Giorgia Meloni','via mariscoli','via asti 19','Agropoli','3489089821');
