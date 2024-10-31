CREATE DATABASE sa2;
USE sa2;
-- DROP DATABASE sa2;

-- QUESTÃO 01
CREATE TABLE sala_de_aula(
	id_sala INT AUTO_INCREMENT PRIMARY KEY,
    capacidade_sala INT NOT NULL,
    localizacao_sala VARCHAR(50) NOT NULL,
    status_sala ENUM('D', 'I') DEFAULT 'D'
);
-- QUESTÃO 02
CREATE TABLE usuarios(
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    dt_nascimento DATE NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE KEY,
    senha VARCHAR(15) NOT NULL
);
-- QUESTÃO 03
CREATE TABLE reserva_sala(
	id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    dt_criacao DATETIME NOT NULL DEFAULT NOW(),
    dt_reserva DATE NOT NULL,
    hr_reserva TIME NOT NULL,
    status_reserva ENUM('A', 'C') DEFAULT'A',
    id_usuario INT,
    id_sala INT,
    CONSTRAINT fk_usuario_reserva FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_sala_reserva FOREIGN KEY (id_sala) REFERENCES sala_de_aula(id_sala)
);
-- QUESTÃO 05
CREATE TABLE cancelamento(
	id_cancelamento INT AUTO_INCREMENT PRIMARY KEY,
    motivo_cancelamento VARCHAR(100) NOT NULL,
    dt_cancelamento DATETIME DEFAULT NOW(),
	id_reserva INT,
    id_sala INT,
    CONSTRAINT fk_reserva_cancelamento FOREIGN KEY (id_reserva) REFERENCES reserva_sala(id_reserva),
    CONSTRAINT fk_sala_cancelamento FOREIGN KEY (id_sala) REFERENCES sala_de_aula(id_sala)
);

DELIMITER $$
-- QUESTÃO 04
CREATE OR REPLACE TRIGGER update_reservas
	AFTER INSERT ON reserva_sala
	FOR EACH ROW
	BEGIN
		UPDATE sala_de_aula AS s
		SET status_sala = 'I'
        WHERE id_sala = NEW.id_sala;
    END $$

-- QUESTÃO 06
CREATE OR REPLACE TRIGGER update_cancelamento
    AFTER INSERT ON cancelamento
    FOR EACH ROW
BEGIN
    UPDATE reserva_sala
    SET status_reserva = 'C'
    WHERE id_reserva = NEW.id_reserva;

    UPDATE sala_de_aula
    SET status_sala = 'D'
    WHERE id_sala = NEW.id_sala;
END $$

-- QUESTÃO 09
CREATE OR REPLACE FUNCTION calc_idade(dt_nascimento DATE)
	RETURNS INT
    RETURN DATEDIFF(NOW(), dt_nascimento)/365.25 $$
DELIMITER ;

-- QUESTÃO 07
CREATE OR REPLACE VIEW salas_disponiveis AS
SELECT * FROM sala_de_aula
WHERE sala_de_aula.status_sala = 'D';

-- QUESTÃO 10
CREATE OR REPLACE VIEW maior_idade AS
	SELECT *,
		FLOOR(DATEDIFF(NOW(), dt_nascimento)/365.25) idade
	FROM usuarios
	HAVING idade > 18;

INSERT INTO usuarios (nome, dt_nascimento, email, senha)
	VALUES ('Marselo', '2015-05-23', 'marselo.jilson@mail.com', '1597532486'),
		('Janete', '2017-12-09', 'janete.caldeirao@mail.com', '13467985200');
        
INSERT INTO sala_de_aula(capacidade_sala, localizacao_sala, status_sala)
VALUES (100, 'Corredor 2-B, Terreo', 'D'),
	(100, 'Corredor 4-D, 1 Andar', 'D'),
	(50, 'Corredor 7-A, 2 Andar', 'D'),
    (50, 'Corredor 1-C, Terreo', 'D');
    
INSERT INTO reserva_sala(dt_reserva, hr_reserva, id_usuario, id_sala)
	VALUES ('2024-11-05', '13:00:00', 1, 4);
    
INSERT INTO cancelamento(id_sala, id_reserva, motivo_cancelamento)
	VALUES(4, 1, 'Falta de alunos');