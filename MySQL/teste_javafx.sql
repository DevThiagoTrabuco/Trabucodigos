CREATE DATABASE aula_crud;
USE aula_crud;
-- DROP DATABASE aula_crud;
-- DROP TABLE funcionarios;

CREATE TABLE funcionarios (
	id_func INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(50) UNIQUE KEY
);