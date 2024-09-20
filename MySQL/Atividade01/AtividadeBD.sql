GRANT USAGE ON *.* TO 'julia'@'localhost' IDENTIFIED BY '0000';
GRANT ALL PRIVILEGES ON *.* TO 'alexandre'@'localhost' IDENTIFIED BY '9999';
-- DROP USER;

GRANT INSERT, SELECT, UPDATE, DELETE ON cinesenai.* TO 'ana'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON cinesenai.* TO 'ana'@'localhost';

GRANT INSERT, SELECT, UPDATE ON cinesenai.filmes TO 'julia'@'localhost';

GRANT SELECT(id_filme, nome_ptbr), UPDATE(nome_ptbr) ON cinesenai.filmes TO 'fabio'@'localhost' IDENTIFIED BY '4321';

REVOKE DELETE ON cinesenai.* FROM 'ana'@'localhost';

REVOKE UPDATE(nome_ptbr) ON cinesenai.filmes FROM 'fabio'@'localhost';

REVOKE ALL PRIVILEGES ON *.* FROM 'alexandre'@'localhost';
REVOKE ALL PRIVILEGES ON *.* FROM 'ana'@'localhost';

SHOW GRANTS FOR 'julia'@'localhost';
SHOW GRANTS FOR 'alexandre'@'localhost';
SHOW GRANTS FOR 'ana'@'localhost';
SHOW GRANTS FOR 'fabio'@'localhost';