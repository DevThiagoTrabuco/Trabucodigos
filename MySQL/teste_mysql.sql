CREATE DATABASE meu_banco;

USE meu_banco;

CREATE TABLE clients(
id_clients INT AUTO_INCREMENT PRIMARY KEY,
name_clients VARCHAR(100) NOT NULL,
email_clients VARCHAR(50) NOT NULL UNIQUE KEY,
cpf_clients CHAR(14) NOT NULL UNIQUE KEY,
brthday_clients DATE,
subscription_date DATETIME DEFAULT now(),
status_clients CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE products(
id_products INT AUTO_INCREMENT PRIMARY KEY,
name_products VARCHAR(100) NOT NULL,
production_date DATE NOT NULL,
expiration_date DATE NOT NULL,
price DOUBLE NOT NULL,
batch INT NOT NULL
);

ALTER TABLE clients
	ADD phone_nmbr CHAR(15);
    
ALTER TABLE clients
	DROP phone_nmbr;
    
USE meu_banco;

ALTER TABLE clients
	ADD phone CHAR(15) AFTER email_clients;

ALTER TABLE clients
	CHANGE phone phone_clients CHAR (15);

CREATE TABLE adresses (
	id_adress INT PRIMARY KEY AUTO_INCREMENT,
	street VARCHAR(50) NOT NULL,
    county VARCHAR(50) NOT NULL,
    adress_number VARCHAR(5),
    city VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    id_clients INT NOT NULL,
    CONSTRAINT fk_id_client FOREIGN KEY(id_clients) REFERENCES clients(id_clients)
);