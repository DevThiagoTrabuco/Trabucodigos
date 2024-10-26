-- QUESTÃO 01: Criar um trigger que toda vez que houver um INSERT na tabela PRODUTOS, serão inseridas a DATA e a HORA desta inserção na tabela CONTROLE.
CREATE DATABASE test00;
USE test00;

CREATE TABLE produtos (
	cod_produto INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR (45) NOT NULL,
	preco DECIMAL (10,5),
	PRIMARY KEY(cod_produto)
);

CREATE TABLE controle (
	registro INT  NOT NULL AUTO_INCREMENT,
	cod_produto INT NOT NULL,
	data_registro DATE,
	hora_registro TIME,
	PRIMARY KEY (registro)
);

DELIMITER $$
CREATE OR REPLACE TRIGGER inserir_data_hora
AFTER INSERT ON produtos
FOR EACH ROW
BEGIN 
	INSERT INTO controle(cod_produto, data_registro, hora_registro) 
		VALUES (NEW.cod_produto, CURDATE(), CURTIME());
END$$
DELIMITER ;

INSERT INTO produtos(nome, preco) VALUES ('marselo', 4.20);

-- QUESTÃO 02: Criar um trigger que sempre que o valor do produto for alterado a trigger será disparada. Colocando a data e hora da alteração na tabela controle_preco, além do preço antigo e preço novo.

USE test00;

CREATE TABLE controle_preco (
	registro INT  NOT NULL AUTO_INCREMENT,
	data_registro DATE,
	hora_registro TIME,
	cod_produto INT NOT NULL,
	preco_antigo DECIMAL (10,2),
	preco_novo DECIMAL (10,2),
	PRIMARY KEY (registro)
);

DELIMITER $$
CREATE OR REPLACE TRIGGER alteracao_preco
AFTER UPDATE ON produtos
FOR EACH ROW
BEGIN
	INSERT INTO controle_preco(cod_produto, data_registro, hora_registro, preco_antigo, preco_novo) 
		VALUES (OLD.cod_produto, CURDATE(), CURTIME(), OLD.preco, NEW.preco);
END $$
DELIMITER ;

UPDATE produtos
	SET preco = 69.0
    WHERE cod_produto = 3;

-- QUESTÃO 03: Criar um trigger para que antes de ser inserido um produto deve ser aplicado um desconto de 10% sobre o preco_normal e atribuido ao preco_desconto

CREATE DATABASE bk;
USE bk;

CREATE TABLE produtos (
    id_produto INT NOT NULL AUTO_INCREMENT,
    nome_produto VARCHAR (45) NOT NULL,
    preco_normal DECIMAL (10,2) NOT NULL,
    preco_desconto DECIMAL (10,2) NOT NULL,
    PRIMARY KEY (id_produto)
);

DELIMITER $$
CREATE OR REPLACE TRIGGER desconto
BEFORE INSERT ON produtos
FOR EACH ROW
BEGIN
	SET NEW.preco_desconto = NEW.preco_normal * 0.9;
END $$
DELIMITER ;