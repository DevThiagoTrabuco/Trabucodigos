CREATE DATABASE procedure_db;
USE procedure_db;

DELIMITER $$
CREATE OR REPLACE PROCEDURE hello_world (nome VARCHAR(50))
BEGIN
	SELECT CONCAT("Hello, ", nome) AS hello;
END $$
DELIMITER ;

CALL hello_world("Gilson");

CREATE TABLE `ex_endereco` (
  `codendereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(100) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` char(2) NOT NULL,
  `codcliente` int(11) NOT NULL,
  PRIMARY KEY (`codendereco`),
  KEY `codcliente` (`codcliente`),
  CONSTRAINT `ex_endereco_ibfk_1` FOREIGN KEY (`codcliente`) REFERENCES `ex_cliente` (`codcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DELIMITER $$
CREATE OR REPLACE PROCEDURE cadastrar_cliente(
	nome VARCHAR(60),
    datanascimento DATE,
    cpf VARCHAR(11),
    logradouro VARCHAR(100),
    bairro VARCHAR (45),
    numero VARCHAR (45),
    cidade VARCHAR (45),
    estado CHAR(2)
)
BEGIN
	DECLARE codcliente INT;
    START TRANSACTION;
		INSERT INTO ex_cliente(nome, datanascimento, cpf)
		VALUES(nome, datanascimento, cpf);
		
		SET codcliente = LAST_INSERT_ID();
		
		INSERT INTO EX_ENDERECO(logradouro, bairro, numero, cidade ,estado, codcliente)
		VALUES(logradouro, bairro, numero, cidade, estado, codcliente);
	COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION fn_teste (a DECIMAL(10,2), b INT)
	RETURNS int
    RETURN a*b $$
DELIMITER ;

SELECT fn_teste(3.9, 15) AS Multiplicação;