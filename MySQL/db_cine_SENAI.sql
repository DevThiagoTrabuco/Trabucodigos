DROP DATABASE CineSENAI;

CREATE DATABASE CineSENAI;
USE CineSENAI;

CREATE TABLE salas(
	id_sala INT PRIMARY KEY AUTO_INCREMENT,
	nome_sala VARCHAR(50) NOT NULL,
    capacidade_sala INT NOT NULL
);
CREATE TABLE sessoes(
	id_sessao INT PRIMARY KEY AUTO_INCREMENT,
    data_sessao DATE NOT NULL,
    idioma_sessao VARCHAR(3) NOT NULL DEFAULT 'DUB'
);
CREATE TABLE assentos(
	id_assentos INT PRIMARY KEY AUTO_INCREMENT,
    num_assentos INT UNIQUE KEY NOT NULL,
    status_assentos VARCHAR(10) NOT NULL DEFAULT 'VAZIO'
);
CREATE TABLE filmes(
	id_filme INT PRIMARY KEY AUTO_INCREMENT,
    nome_ptbr VARCHAR(50) NOT NULL,
    nome_eng VARCHAR(50),
    sinopse_filme VARCHAR(300) UNIQUE KEY,
    ano_lancamento DATE NOT NULL,
    classificacao_filme VARCHAR(3) NOT NULL DEFAULT 'L'
);
CREATE TABLE genero(
	id_genero INT PRIMARY KEY AUTO_INCREMENT,
    nome_genero VARCHAR(50) NOT NULL
);
CREATE TABLE diretor(
	id_diretor INT PRIMARY KEY AUTO_INCREMENT,
    nome_diretor VARCHAR(50) NOT NULL
);
CREATE TABLE diretores_filme(
	id_diretores_filme INT PRIMARY KEY AUTO_INCREMENT
);
CREATE TABLE empregados(
	id_empregados INT PRIMARY KEY AUTO_INCREMENT,
    nome_empregados VARCHAR(100) NOT NULL,
    cpf_empregados VARCHAR(11) NOT NULL,
    telefone_empregados VARCHAR(11) NOT NULL
);
CREATE TABLE cargos(
	id_cargos INT PRIMARY KEY AUTO_INCREMENT,
    cargo VARCHAR(50) NOT NULL,
    sts_cargo VARCHAR(10)
);
CREATE TABLE ingressos(
	id_ingresso INT PRIMARY KEY AUTO_INCREMENT
);
CREATE TABLE tipo_ingresso(
	id_tipo INT PRIMARY KEY AUTO_INCREMENT,
    nome_tipo VARCHAR(50) NOT NULL,
    sts_tipo VARCHAR(50) NOT NULL,
    preco_ingresso DOUBLE NOT NULL
);
CREATE TABLE vendas(
	id_venda INT PRIMARY KEY AUTO_INCREMENT,
    data_venda DATE NOT NULL
);
CREATE TABLE item_venda(
	id_item INT PRIMARY KEY AUTO_INCREMENT,
    nome_item VARCHAR(50) NOT NULL
);
CREATE TABLE tipo_pagamento(
	id_tipo_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    nome_tipo VARCHAR(25) NOT NULL,
    sts_tipo VARCHAR(25) NOT NULL
);

ALTER TABLE filmes
	ADD CONSTRAINT fk_filmes_genero FOREIGN KEY (id_genero) REFERENCES genero(id_genero),
	ADD CONSTRAINT fk_filmes_diretores_filme FOREIGN KEY (id_diretores_filme) REFERENCES diretores_filme(id_diretores_filme);
ALTER TABLE diretores_filme
	ADD CONSTRAINT fk_diretores_filme_filmes FOREIGN KEY (id_filme) REFERENCES filmes(id_filme),
	ADD CONSTRAINT fk_diretores_filme_diretor FOREIGN KEY (id_diretor) REFERENCES diretor(id_diretor);
ALTER TABLE sessoes
	ADD CONSTRAINT fk_sessoes_filmes FOREIGN KEY (id_filme) REFERENCES filmes(id_filme),
	ADD CONSTRAINT fk_sessoes_ingressos FOREIGN KEY (id_ingresso) REFERENCES ingressos(id_ingresso);
ALTER TABLE assentos
	ADD CONSTRAINT fk_assentos_salas FOREIGN KEY (id_sala) REFERENCES salas(id_sala);
ALTER TABLE salas
	ADD CONSTRAINT fk_salas_sessoes FOREIGN KEY (id_sessao) REFERENCES sessoes(id_sessao);
ALTER TABLE ingressos
	ADD CONSTRAINT fk_ingressos_sessoes FOREIGN KEY (id_sessao) REFERENCES sessoes(id_sessao),
	ADD CONSTRAINT fk_ingressos_tipo FOREIGN KEY (id_tipo) REFERENCES tipo_ingresso(id_tipo),
	ADD CONSTRAINT fk_ingressos_assentos FOREIGN KEY (id_assento) REFERENCES assentos(id_assento);
ALTER TABLE empregados
	ADD CONSTRAINT fk_empregados_cargos FOREIGN KEY (id_cargos) REFERENCES cargos(id_cargos);
ALTER TABLE vendas
	ADD CONSTRAINT fk_vendas_empregados FOREIGN KEY (id_empregado) REFERENCES empregados(id_empregados),
	ADD CONSTRAINT fk_vendas_tipo_pagamento FOREIGN KEY (id_tipo_pagamento) REFERENCES tipo_pagamento(id_tipo_pagamento),
	ADD CONSTRAINT fk_vendas_item_venda FOREIGN KEY (id_item) REFERENCES item_venda(id_item);
ALTER TABLE item_venda
	ADD CONSTRAINT fk_item_venda_vendas FOREIGN KEY (id_venda) REFERENCES vendas(id_venda),
	ADD CONSTRAINT fk_item_venda_ingressos FOREIGN KEY (id_ingresso) REFERENCES ingressos(id_ingresso),
	ADD CONSTRAINT fk_item_venda_assentos FOREIGN KEY (id_assento) REFERENCES assentos(id_assento),
	ADD CONSTRAINT fk_item_venda_tipo_ingresso FOREIGN KEY (id_tipo) REFERENCES tipo_ingresso(id_tipo),
	ADD CONSTRAINT fk_item_venda_preco_ingresso FOREIGN KEY (preco_ingresso) REFERENCES tipo_ingresso(preco_ingresso);
    
-- ADICIONAR FK EM CADA TABELA