DROP DATABASE CineSENAI;
-- DROP TABLE;
SET SQL_SAFE_UPDATES = 1;

CREATE DATABASE CineSENAI;
USE CineSENAI;

CREATE TABLE genero( -- OK
	id_genero INT PRIMARY KEY AUTO_INCREMENT,
    nome_genero VARCHAR(50) NOT NULL
);
CREATE TABLE diretor( -- OK
	id_diretor INT PRIMARY KEY AUTO_INCREMENT,
    nome_diretor VARCHAR(50) NOT NULL
);
CREATE TABLE diretores_filme(
	id_diretores_filme INT PRIMARY KEY AUTO_INCREMENT,
    id_filme INT,
    id_diretor INT,
	CONSTRAINT fk_diretores_filme_diretor FOREIGN KEY (id_diretor) REFERENCES diretor(id_diretor)
);
CREATE TABLE filmes(
	id_filme INT PRIMARY KEY AUTO_INCREMENT,
    nome_ptbr VARCHAR(50) NOT NULL,
    nome_eng VARCHAR(50),
    sinopse_filme VARCHAR(300) UNIQUE KEY,
    ano_lancamento DATE NOT NULL,
    classificacao_filme VARCHAR(3) DEFAULT 'L',
    id_genero INT,
    id_diretores_filme INT,
    CONSTRAINT fk_filmes_genero FOREIGN KEY (id_genero) REFERENCES genero(id_genero),
	CONSTRAINT fk_filmes_diretores_filme FOREIGN KEY (id_diretores_filme) REFERENCES diretores_filme(id_diretores_filme)
);
CREATE TABLE tipo_ingresso( -- OK
	id_tipo INT PRIMARY KEY AUTO_INCREMENT,
    nome_tipo VARCHAR(50) NOT NULL,
    sts_tipo VARCHAR(50) NOT NULL,
    preco_ingresso DECIMAL(10,2) NOT NULL
);
CREATE TABLE sessoes(
	id_sessao INT PRIMARY KEY AUTO_INCREMENT,
    data_sessao DATETIME NOT NULL,
    idioma_sessao ENUM('LEG', 'DUB') NOT NULL DEFAULT 'DUB'
);
CREATE TABLE salas( -- OK
	id_sala INT PRIMARY KEY AUTO_INCREMENT,
	nome_sala VARCHAR(50) NOT NULL,
    capacidade_sala INT NOT NULL,
    id_sessao INT,
    CONSTRAINT fk_salas_sessoes FOREIGN KEY (id_sessao) REFERENCES sessoes(id_sessao)
);
CREATE TABLE assentos( -- OK
	id_assentos INT PRIMARY KEY AUTO_INCREMENT,
    num_assentos INT NOT NULL,
    status_assentos ENUM('R', 'D', 'I') NOT NULL DEFAULT 'D',
    id_sala INT,
    CONSTRAINT fk_assentos_salas FOREIGN KEY (id_sala) REFERENCES salas(id_sala)
);
CREATE TABLE cargos( -- OK
	id_cargos INT PRIMARY KEY AUTO_INCREMENT,
    cargo VARCHAR(50) NOT NULL,
    sts ENUM('A', 'I') DEFAULT 'A'
);
CREATE TABLE empregados(
	id_empregados INT PRIMARY KEY AUTO_INCREMENT,
    nome_empregados VARCHAR(100) NOT NULL,
    cpf_empregados VARCHAR(11) NOT NULL,
    telefone_empregados VARCHAR(11) NOT NULL,
    sts_empregados ENUM('A', 'I') DEFAULT 'A'
);
CREATE TABLE ingressos(
	id_ingresso INT PRIMARY KEY AUTO_INCREMENT,
    id_sessao INT,
    id_tipo INT,
    id_assentos INT,
    CONSTRAINT fk_ingressos_sessoes FOREIGN KEY (id_sessao) REFERENCES sessoes(id_sessao),
	CONSTRAINT fk_ingressos_tipo FOREIGN KEY (id_tipo) REFERENCES tipo_ingresso(id_tipo),
	CONSTRAINT fk_ingressos_assentos FOREIGN KEY (id_assentos) REFERENCES assentos(id_assentos)
);
CREATE TABLE tipo_pagamento( -- OK
	id_tipo_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    nome_tipo VARCHAR(25) NOT NULL,
    sts_tipo VARCHAR(25) NOT NULL
);
CREATE TABLE item_venda(
	id_item INT PRIMARY KEY AUTO_INCREMENT,
    nome_item VARCHAR(50) NOT NULL,
    data_venda DATETIME DEFAULT NOW(),
    id_ingresso INT,
    id_assentos INT,
    id_tipo INT,
	CONSTRAINT fk_item_venda_ingressos FOREIGN KEY (id_ingresso) REFERENCES ingressos(id_ingresso),
	CONSTRAINT fk_item_venda_assentos FOREIGN KEY (id_assentos) REFERENCES assentos(id_assentos),
	CONSTRAINT fk_item_venda_tipo_ingresso FOREIGN KEY (id_tipo) REFERENCES tipo_ingresso(id_tipo)
);
CREATE TABLE vendas(
	id_venda INT PRIMARY KEY AUTO_INCREMENT,
    data_venda DATETIME NOT NULL,
    id_empregados INT,
    id_tipo_pagamento INT,
    id_item INT,
	CONSTRAINT fk_vendas_empregados FOREIGN KEY (id_empregados) REFERENCES empregados(id_empregados),
	CONSTRAINT fk_vendas_tipo_pagamento FOREIGN KEY (id_tipo_pagamento) REFERENCES tipo_pagamento(id_tipo_pagamento),
	CONSTRAINT fk_vendas_item_venda FOREIGN KEY (id_item) REFERENCES item_venda(id_item)
);
CREATE TABLE horario( -- OK
	id_horario INT PRIMARY KEY AUTO_INCREMENT,
    hora_sessao TIME
);

ALTER TABLE empregados
	ADD email_empregados VARCHAR(50) NOT NULL UNIQUE AFTER nome_empregados,
    ADD id_cargos INT,
    ADD CONSTRAINT fk_empregados_cargos FOREIGN KEY (id_cargos) REFERENCES cargos(id_cargos);

ALTER TABLE cargos
	CHANGE sts sts_cargos ENUM('A', 'I') DEFAULT 'I';
    
ALTER TABLE diretores_filme
	ADD CONSTRAINT fk_diretores_filme_filmes FOREIGN KEY (id_filme) REFERENCES filmes(id_filme);

ALTER TABLE filmes
	DROP COLUMN id_diretores_filme,
    DROP CONSTRAINT fk_filmes_diretores_filme;
ALTER TABLE diretores_filme
	DROP COLUMN id_diretores_filme;

ALTER TABLE sessoes
	ADD id_horario INT AFTER data_sessao,
    ADD CONSTRAINT fk_sessoes_horario FOREIGN KEY (id_horario) REFERENCES horario(id_horario);

ALTER TABLE tipo_ingresso
	MODIFY COLUMN sts_tipo ENUM('A', 'I') DEFAULT 'A';
    
ALTER TABLE tipo_ingresso
	ADD CONSTRAINT tipo_unico UNIQUE (nome_tipo);
    
ALTER TABLE tipo_pagamento
	MODIFY COLUMN sts_tipo ENUM ('A', 'I') DEFAULT 'A',
    ADD CONSTRAINT tipo_pagamento_unico UNIQUE (nome_tipo);

INSERT INTO genero (nome_genero)
	VALUES ('Ação'), ('Drama'), ('Romance'),
    ('Aventura'), ('Suspense'), ('Terror'),
    ('Comédia'), ('Ficção_Científica'), ('Fantasia'),
    ('Animação');
    
INSERT INTO diretor (nome_diretor)
	VALUES ('Alfred Hitchcock'), ('Stanley Kubrick'), ('Martin Scorcese'),
    ('Steven Spielberg'), ('Quentin Tarantino'), ('Francis Ford Coppola'),
    ('Ridley Scott'), ('Christopher Nolan'), ('James Cameron'),
    ('Wes Anderson'), ('Pedro Almodóvar'), ('Hayao Miyazaki'),
    ('David Fincher'), ('Coen Brothers'), ('Jean-Luc Godard');
    
INSERT INTO salas (nome_sala, capacidade_sala)
	VALUES ('ALPHA', 50), ('BETA', 50),
    ('GAMMA', 50), ('DELTA', 50), ('SIGMA', 50);
    
INSERT INTO tipo_ingresso(nome_tipo, preco_ingresso)
	VALUES ('Inteira',24.50),
    ('Meia', 12.25),
    ('Estudante', 15.00),
    ('Combo Casal', 40.00);
    
INSERT INTO tipo_pagamento (nome_tipo)
	VALUES ('Crédito'), ('Débito'),
    ('PIX'), ('Á vista');

INSERT INTO cargos (cargo)
	VALUES ('Gerente'), ('Supervisor de sala'),
    ('Operador de projetor'), ('Operador da lanchonete'), ('Bilheteiro'), ('Caixa'),
    ('Zelador'), ('Segurança');

INSERT INTO horario (hora_sessao)
	VALUES ('09:00'), ('10:30'), ('12:00'),
    ('13:30'), ('15:00'), ('16:30'),
    ('18:00'), ('19:30'), ('21:00'), ('22:30'); 

INSERT INTO assentos (num_assentos, id_sala)
	VALUES (1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9, 1), (10, 1),
(11, 1), (12, 1), (13, 1), (14, 1), (15, 1), (16, 1), (17, 1), (18, 1), (19, 1), (20, 1),
(21, 1), (22, 1), (23, 1), (24, 1), (25, 1), (26, 1), (27, 1), (28, 1), (29, 1), (30, 1),
(31, 1), (32, 1), (33, 1), (34, 1), (35, 1), (36, 1), (37, 1), (38, 1), (39, 1), (40, 1),
(41, 1), (42, 1), (43, 1), (44, 1), (45, 1), (46, 1), (47, 1), (48, 1), (49, 1), (50, 1), 
(1, 2), (2, 2), (3, 2), (4, 2), (5, 2), (6, 2), (7, 2), (8, 2), (9, 2), (10, 2),
(11, 2), (12, 2), (13, 2), (14, 2), (15, 2), (16, 2), (17, 2), (18, 2), (19, 2), (20, 2),
(21, 2), (22, 2), (23, 2), (24, 2), (25, 2), (26, 2), (27, 2), (28, 2), (29, 2), (30, 2),
(31, 2), (32, 2), (33, 2), (34, 2), (35, 2), (36, 2), (37, 2), (38, 2), (39, 2), (40, 2),
(41, 2), (42, 2), (43, 2), (44, 2), (45, 2), (46, 2), (47, 2), (48, 2), (49, 2), (50, 2),
(1, 3), (2, 3), (3, 3), (4, 3), (5, 3), (6, 3), (7, 3), (8, 3), (9, 3), (10, 3),
(11, 3), (12, 3), (13, 3), (14, 3), (15, 3), (16, 3), (17, 3), (18, 3), (19, 3), (20, 3),
(21, 3), (22, 3), (23, 3), (24, 3), (25, 3), (26, 3), (27, 3), (28, 3), (29, 3), (30, 3),
(31, 3), (32, 3), (33, 3), (34, 3), (35, 3), (36, 3), (37, 3), (38, 3), (39, 3), (40, 3),
(41, 3), (42, 3), (43, 3), (44, 3), (45, 3), (46, 3), (47, 3), (48, 3), (49, 3), (50, 3),
(1, 4), (2, 4), (3, 4), (4, 4), (5, 4), (6, 4), (7, 4), (8, 4), (9, 4), (10, 4),
(11, 4), (12, 4), (13, 4), (14, 4), (15, 4), (16, 4), (17, 4), (18, 4), (19, 4), (20, 4),
(21, 4), (22, 4), (23, 4), (24, 4), (25, 4), (26, 4), (27, 4), (28, 4), (29, 4), (30, 4),
(31, 4), (32, 4), (33, 4), (34, 4), (35, 4), (36, 4), (37, 4), (38, 4), (39, 4), (40, 4),
(41, 4), (42, 4), (43, 4), (44, 4), (45, 4), (46, 4), (47, 4), (48, 4), (49, 4), (50, 4),
(1, 5), (2, 5), (3, 5), (4, 5), (5, 5), (6, 5), (7, 5), (8, 5), (9, 5), (10, 5),
(11, 5), (12, 5), (13, 5), (14, 5), (15, 5), (16, 5), (17, 5), (18, 5), (19, 5), (20, 5),
(21, 5), (22, 5), (23, 5), (24, 5), (25, 5), (26, 5), (27, 5), (28, 5), (29, 5), (30, 5),
(31, 5), (32, 5), (33, 5), (34, 5), (35, 5), (36, 5), (37, 5), (38, 5), (39, 5), (40, 5),
(41, 5), (42, 5), (43, 5), (44, 5), (45, 5), (46, 5), (47, 5), (48, 5), (49, 5), (50, 5);
