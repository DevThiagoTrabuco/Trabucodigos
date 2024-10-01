CREATE DATABASE SA1;
USE SA1;
-- DROP DATABASE SA1;
-- SET SQL_SAFE_UPDATES = 0;

CREATE TABLE clientes( -- OK
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE KEY,
    cpf VARCHAR(11) NOT NULL UNIQUE KEY,
    telefone VARCHAR(11) NOT NULL
);
    
CREATE TABLE produtos( -- OK
	id_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL UNIQUE KEY,
    preco DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL,
    id_fornecedor INT,
    id_tp_produto INT
);
    
CREATE TABLE tp_produtos( -- OK
	id_tp_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL UNIQUE KEY
);

CREATE TABLE pedidos( -- OK
	id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    data_pedido DATETIME NOT NULL DEFAULT NOW(),
    id_cliente INT,
    id_produto INT,
    quantidade INT NOT NULL,
    id_pagamento INT,
    id_funcionario INT
);
    
CREATE TABLE fornecedores( -- OK
	id_fornecedor INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL
);
    
CREATE TABLE funcionarios( -- OK
	id_funcionario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    id_cargo INT
);
    
CREATE TABLE cargos( -- OK
	id_cargo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL UNIQUE KEY,
    salario DECIMAL(10, 2) NOT NULL
);
    
CREATE TABLE enderecos( -- OK
	id_endereco INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    logradouro VARCHAR(100) NOT NULL,
    numero INT,
    complemento VARCHAR(20),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    UF VARCHAR(2) NOT NULL
);
    
CREATE TABLE pagamentos( -- OK
	id_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL UNIQUE KEY,
    sts ENUM('A', 'I') NOT NULL DEFAULT 'A'
);

ALTER TABLE enderecos
	ADD CONSTRAINT id_enderecos_clientes FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente);
    
ALTER TABLE produtos
	ADD CONSTRAINT id_produtos_fornecedores FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id_fornecedor),
    ADD CONSTRAINT id_produto_tipo FOREIGN KEY (id_tp_produto) REFERENCES tp_produtos(id_tp_produto);
    
ALTER TABLE pedidos
	ADD CONSTRAINT id_pedidos_clientes FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    ADD CONSTRAINT id_pedidos_produtos FOREIGN KEY (id_produto) REFERENCES produtos(id_produto),
    ADD CONSTRAINT id_pedidos_pagamento FOREIGN KEY (id_pagamento) REFERENCES pagamentos(id_pagamento),
    ADD CONSTRAINT id_pedidos_funcionarios FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id_funcionario);
    
ALTER TABLE funcionarios
	ADD CONSTRAINT id_funcionarios_cargo FOREIGN KEY (id_cargo) REFERENCES cargos(id_cargo);
    
INSERT INTO pagamentos(nome)
	VALUES ('Boleto'), ('Crédito'), ('Débito'), ('PIX'), ('PayPal');

INSERT INTO cargos(nome, salario)
	VALUES ('Gerente', 2500), ('Vendedor', 1250), ('Marketing', 2000), ('Op. de Logística', 1650);
    
INSERT INTO fornecedores(nome)
	VALUES ('Atacadão'), ('Total Distribuidora'), ('DPC'), ('Feirita'), ('Unimarka');
    
INSERT INTO tp_produtos(nome)
	VALUES('Alimento'), ('Higiene'), ('Limpeza'), ('Beleza'), ('Escritorio'), ('Casa'), ('Vestuario');
    
INSERT INTO produtos(nome, preco, estoque, id_tp_produto, id_fornecedor)
	VALUES('Creme dental', 1.50, 50, 2, 2), ('Papel higienico', 7.50, 30, 2, 1), 
    ('Shampoo Head&Shoulders', 10.25, 25, 4, 5), ('Sabonete liquido', 5.25, 55, 2, 3), 
    ('Cadeira de escritorio', 225.40, 20, 5, 4), ('Camisa polo insider', 115.40, 20, 7, 5),
    ('Revista times', 10.50, 20, 5, 5);
    
INSERT INTO clientes(nome, email, cpf, telefone)
	VALUES('Jorge Oliveira', 'jorge@email.com', '01234567891', '75912345678'),
    ('Marselo Almeida', 'marselo@email.com', '02234567891', '75922345678'),
    ('Vampeta da Silva', 'vampeta@email.com', '03234567891', '75932345678'),
    ('Vitor Gemaplys', 'vitor@email.com', '04234567891', '75942345678'),
    ('Jean Cheroso', 'jean@email.com', '05234567891', '75952345678');
    
INSERT INTO funcionarios(nome, id_cargo)
	 VALUES ('Tiago Carneiro', 2), ('Mateus Alcantara', 2), ('Gabriel Oliveira', 3),
     ('Sayd Aires', 4), ('Miguel Neto', 4), ('Cictor Koak', 1), ('Vampeta', 2);
     
INSERT INTO enderecos(id_cliente, logradouro, numero, complemento, bairro, cidade, UF)
	VALUES (1, 'Rua dos bobos', 0, 'Rua sem entrada', 'Queimadinha', 'Feira de Santana', 'BA'),
    (2, 'Rua dos bobos', 0, 'Rua sem entrada', 'Queimadinha', 'Feira de Santana', 'BA'),
    (3, 'Rua do Corno', 73, NULL, 'Centro', 'São Luís', 'MA'),
    (4, 'Estrada Pé do Viado', 69, NULL, 'Novo Horizonte', 'Aracaju', 'SE'),
    (5, 'Rua Sem Fim', 999, NULL, 'Centro', 'Cabo Frio', 'RJ');
    
INSERT INTO pedidos(id_cliente, id_produto, quantidade, id_pagamento, id_funcionario)
	VALUES(1,2,2,3,1), (1,4,5,3,1), (1,5,2,2,7), (2,1,2,2,1), (2,2,7,2,2), (4,3,5,1,7), (3,2,10,3,1);
    
SELECT clientes.id_cliente AS 'Id_cliente',
		clientes.nome AS 'Nome', 
        logradouro, 
        numero, 
        complemento, 
        bairro, 
        cidade, 
        UF
FROM enderecos
JOIN clientes
ON clientes.id_cliente = enderecos.id_cliente
WHERE logradouro = 'Rua dos bobos';

SELECT funcionarios.id_funcionario AS 'Id_func',
		funcionarios.nome AS 'Nome_func'
FROM pedidos
JOIN funcionarios
ON funcionarios.id_funcionario = pedidos.id_funcionario
GROUP BY pedidos.id_pedido;

CREATE VIEW V_func_X_pedidos
AS SELECT funcionarios.id_funcionario AS 'Id_func',
		funcionarios.nome AS 'Nome_func'
FROM pedidos p,
funcionarios f
WHERE funcionarios.id_funcionario = pedidos.id_funcionario
GROUP BY pedidos.id_pedido;

SELECT * 
FROM V_func_X_pedidos
WHERE Id_func < 5
