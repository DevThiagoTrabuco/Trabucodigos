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
    classificacao_filme VARCHAR(3) NOT NULL DEFAULT 'L',
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
CREATE TABLE assentos(
	id_assentos INT PRIMARY KEY AUTO_INCREMENT,
    num_assentos VARCHAR(4) UNIQUE KEY NOT NULL,
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
	VALUES ('ALPHA', 100), ('BETA', 50),
    ('GAMMA', 50), ('DELTA', 50), ('SIGMA', 50);
    
ALTER TABLE tipo_ingresso
	MODIFY COLUMN sts_tipo ENUM('A', 'I') DEFAULT 'A';
    
ALTER TABLE tipo_ingresso
	ADD CONSTRAINT tipo_unico UNIQUE (nome_tipo);
    
ALTER TABLE tipo_pagamento
	MODIFY COLUMN sts_tipo ENUM ('A', 'I') DEFAULT 'A',
    ADD CONSTRAINT tipo_pagamento_unico UNIQUE (nome_tipo);

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
    
ALTER TABLE filmes
	MODIFY COLUMN classificacao_filme ENUM('L', '10', '12', '14', '16', '18') DEFAULT 'L';

SELECT * FROM horario;

CREATE TABLE horario( -- OK
	id_horario INT PRIMARY KEY AUTO_INCREMENT,
    hora_sessao TIME
);

INSERT INTO horario (hora_sessao)
	VALUES ('09:00'), ('10:30'), ('12:00'),
    ('13:30'), ('15:00'), ('16:30'),
    ('18:00'), ('19:30'), ('21:00'), ('22:30'); 
    
ALTER TABLE sessoes
	ADD id_horario INT AFTER data_sessao,
    ADD CONSTRAINT fk_sessoes_horario FOREIGN KEY (id_horario) REFERENCES horario(id_horario);