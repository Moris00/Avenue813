
DROP DATABASE IF EXISTS Avenue813;

CREATE DATABASE Avenue813;

USE Avenue813;

drop user if exists 'admin'@'localhost';  

create user 'admin'@'localhost' identified by 'Avenue813';

GRANT ALL ON Avenue813.* to 'admin'@'localhost';

DROP TABLE IF EXISTS Customers ;

CREATE TABLE Customers(id int PRIMARY KEY auto_increment not null,
					   email VarChar(30) NOT NULL,
                       numero_ordini int default 0,
                       passw VARCHAR(45) NOT NULL,
                       pname VARCHAR(16),
                       secondname VARCHAR(16),
                       username VARCHAR(16),
                       address VARCHAR(20),
                       shippinh_address VARCHAR(20),
                       country varchar(10),
                       phone varchar(10),
                       amministrator Boolean Default 0);


DROP TABLE IF EXISTS Products ;

CREATE TABLE Products(id int PRIMARY KEY NOT NULL auto_increment,
					  nome VARCHAR(25) ,
                      price Double,
                      descrizione VARCHAR(80),
                      category VARCHAR(10),
                      stock int,
                      pathImage VARCHAR(200),
                      sesso varchar(15),
                      disp boolean default true) ;
                      
DROP TABLE IF EXISTS Orders ;

CREATE TABLE Orders(id int PRIMARY KEY NOT NULL auto_increment,
					numero_ordini int not null,
					customer_id int NOT NULL , 
                    product_id int NOT NULL, 
                    amount VARCHAR(10) NOT NULL, 
                    order_address VARCHAR(15), 
                    method_pagament VARCHAR(25) , 
                    order_date varchar(50), 
					nome varchar(15),
                    cognome varchar(15),
                    telefono int,
                    foreign key (customer_id) references Customers(id), 
                    foreign key (product_id) references Products(id));



insert into Customers(email, passw, pname, secondname, username) values ('primo@gmail.com','cHJpbW8=','Silvio','Berlusconi','Silvio99');
insert into Customers(email, passw, pname, secondname, username, amministrator) values ('second@gmail.com','YWRtaW4=','Maurizio','Ricco','moris', 1);
insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("Air Force 1 Nike Bianco", 100.00, "Preparati a volare con le nuove Nike Shoes", "Sneakers", "/Avenue813/immagini_prodotti/airforce1.png", 3,"uomo");
insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("Felpa Fila Nera", 70.00, "Una bellissima felpa di cotone di colore nero ti attende", "Maglie", "/Avenue813/immagini_prodotti/felpafila.png", 5, "uomo");
insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("Cappello Adidas", 25.00, "Proteggiti dal caldo con un berretto Adidas", "Accessori", "/Avenue813/immagini_prodotti/cappelloadidas.png", 5, "uomo");
insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("Calzini Nike G/W/B", 12.00, "Di sicuro non sono calzini della Kappa", "Accessori", "/Avenue813/immagini_prodotti/calzini_gray_white_black.png", 5, "uomo");
insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("Calzini Nike G/W/B", 12.00, "Di sicuro non sono calzini della Kappa", "Accessori", "/Avenue813/immagini_prodotti/eren.jpg", 5, "uomo");

insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("Leggins Nike Gray", 65.00, "Un bellissimo leggins per le signore amanti dello sport", "Pantaloni", "/Avenue813/immagini_prodotti/leggins_gray.png", 5, "donna");
insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("Tuta Adidas Completa", 70.00, "E' una semplice tuta però nero e fucsia", "Maglie", "/Avenue813/immagini_prodotti/adidas_tuta_completa.png", 5, "donna");
insert into Products(nome, price, descrizione, category, pathImage, stock, sesso) values("T-Shirt Fila", 23.00, "Una T-Shirt da donna con tutto rispetto", "Maglie", "/Avenue813/immagini_prodotti/tshirt_fila.png", 5, "donna");
