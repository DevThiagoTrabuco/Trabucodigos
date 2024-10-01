CREATE DATABASE loja;
USE loja;
-- DROP DATABASE loja;

CREATE TABLE produtos(
	cod INT AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR (45),
	preco DECIMAL(10,2),
	qtd INT
);

INSERT INTO produtos(descricao, preco, qtd) VALUES ('Monitor 27 4K ',2890,30),
	('Mouse USB ',70,50), ('TV 27 4K ',1900,80), ('Gabinete 4K ',100,90),
	('Placa de Vídeo ',5000,50), ('Windows 11 27 4K ',150,80), ('Teclado USB 4K ',79.90,100),
	('Cabo USB ',35.80,70), ('Smartphone ',1750,30), ('Ventilador ',189.90,100),
	('Geladeira',5000,90), ('Fogão ',1300,80), ('Teclado CASSIO',6500,50), ('Mochila ',79.90,50),
	('Armário ',1850,10), ('Monitor 30 4K ',3000,80), ('Monitor 27 4K ',2890,30), ('Mouse USB ',70,50),
	('TV 27 4K ',1900,80), ('Gabinete 4K ',100,90), ('Placa de Vídeo ',5000,50), ('Windows 11 27 4K ',150,80),
	('Teclado USB 4K ',79.90,100), ('Cabo USB ',35.80,70), ('Smartphone ',1750,30), ('Ventilador ',189.90,100),
	('Geladeira',5000,90), ('Fogão ',1300,80), ('Teclado CASSIO',6500,50), ('Mochila ',79.90,50),
	('Armário ',1850,10), ('Monitor 30 4K ',3000,80), ('Monitor 55 4K ',13000,50), ('Monitor 27 4K ',2890,30),
	('Mouse USB ',70,50), ('TV 27 4K ',1900,80), ('Gabinete 4K ',100,90), ('Placa de Vídeo ',5000,50),
	('Windows 11 27 4K ',150,80), ('Teclado USB 4K ',79.90,100), ('Cabo USB ',35.80,70), ('Smartphone ',1750,30),
	('Ventilador ',189.90,100), ('Geladeira',5000,90), ('Fogão ',1300,80), ('Teclado CASSIO',6500,50),
	('Mochila ',79.90,50), ('Armário ',1850,10), ('Monitor 30 4K ',3000,80), ('Monitor 55 4K ',13000,50),
	('Monitor 27 4K ',2890,30), ('Mouse USB ',70,50), ('TV 27 4K ',1900,80), ('Gabinete 4K ',100,90),
	('Placa de Vídeo ',5000,50), ('Windows 11 27 4K ',150,80), ('Teclado USB 4K ',79.90,100),
	('Cabo USB ',35.80,70), ('Smartphone ',1750,30), ('Ventilador ',189.90,100),
	('Geladeira',5000,90), ('Fogão ',1300,80), ('Teclado CASSIO',6500,50), ('Mochila ',79.90,50),
	('Armário ',1850,10), ('Monitor 30 4K ',3000,80), ('Monitor 55 4K ',13000,50), ('Monitor 27 4K ',2890,30),
	('Mouse USB ',70,50), ('TV 27 4K ',1900,80), ('Gabinete 4K ',100,90), ('Placa de Vídeo ',5000,50);

CREATE OR REPLACE VIEW V_sum AS
SELECT SUM(preco*qtd) AS total_preco
FROM produtos;

CREATE OR REPLACE VIEW V_avg AS
SELECT ROUND(AVG(preco*qtd), 2) AS Media_preco
FROM produtos;

CREATE OR REPLACE VIEW V_higher AS
SELECT *
FROM produtos
WHERE preco = (SELECT MAX(preco) FROM produtos);

CREATE OR REPLACE VIEW V_lower AS
SELECT *
FROM produtos
WHERE preco = (SELECT MIN(preco) FROM produtos);

CREATE OR REPLACE VIEW V_total AS
SELECT descricao AS Nome,
SUM(preco*qtd) AS Total_preco
FROM produtos
GROUP BY descricao;

SELECT * FROM V_sum;
SELECT * FROM V_avg;
SELECT * FROM V_higher;
SELECT * FROM V_lower;
SELECT * FROM V_total;