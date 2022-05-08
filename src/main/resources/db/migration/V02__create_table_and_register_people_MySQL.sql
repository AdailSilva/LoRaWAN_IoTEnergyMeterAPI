-- MySQL

-- -----------------------------------------------------
-- Schema iotenergymeterapi
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `iotenergymeterapi` ;
--USE `iotenergymeterapi` ;


CREATE TABLE system_people (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  public_place VARCHAR(50) NULL,
  address_number VARCHAR(6) NULL,
  complement VARCHAR(100) NULL,
  neighborhood VARCHAR(30) NULL,
  cep VARCHAR(10) NULL,
  city VARCHAR(30) NULL,
  state VARCHAR(30) NULL,
  active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


-- -----------------------------------------------------
-- Selecting the `iotenergymeterapi` database
-- -----------------------------------------------------
--USE `iotenergymeterapi`;


INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Adail dos Santos Silva', 'Rua do Abacaxi', '101', 'Próximo ao Centro', 'Brasil', '62.500-000', 'Itapipoca', 'CE', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('João Rodrigues da Silva', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-120', 'Ribeirão Preto', 'SP', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Teresa Cristina dos Santos Silva', 'Rua Professor Osvaldo Nogueira Lima', '505', 'Próximo ao Centro', 'Morumbi', '62.320-000', 'Tianguá', 'CE', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Abigail dos Santos Silva', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-112', 'Salvador', 'BA', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Alice dos Santos Silva', 'Av Rio Branco', '321', 'Próximo ao Centro', 'Jardins', '56.400-121', 'Natal', 'RN', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Avila dos Santos Silva', 'Av Brasil', '100', 'Próximo ao Centro', 'Tubalina', '77.400-122', 'Porto Alegre', 'RS', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-212', 'Rio de Janeiro', 'RJ', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Carlos Santana', 'Rua da Manga', '433', 'Próximo ao Centro', 'Centro', '31.400-122', 'Belo Horizonte', 'MG', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Leonardo Oliveira', 'Rua do Músico', '566', 'Próximo ao Centro', 'Segismundo Pereira', '38.400-100', 'Uberlândia', 'MG', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-122', 'Manaus', 'AM', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Josué Teixeira dos Santos', 'Rua do Meio', '344', 'Próximo ao Centro', 'Brasil', '62.500-000', 'Tianguá', 'CE', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Adriano de Sousa Rodrigues', 'Rua 12 de Agosto', '76', 'Apto 404', 'Caeira', '11.400-120', 'Ubajara', 'CE', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Fernando Cristiano Santos', 'Rua Professor Osvaldo Nogueira Lima', '1005', 'Próximo ao Centro', 'Laurão', '62.320-000', 'Tianguá', 'CE', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Clébio Silva', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-112', 'Salvador', 'BA', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Antônio Medeiros', 'Av Rio Branco', '321', 'Próximo ao Centro', 'Jardins', '56.400-121', 'Natal', 'RN', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('José Nicolau', 'Av Brasil', '100', 'Próximo ao Centro', 'Tubalina', '77.400-122', 'Porto Alegre', 'RS', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Bruna Marinho', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-212', 'Rio de Janeiro', 'RJ', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Felipe Santos', 'Rua da Manga', '433', 'Próximo ao Centro', 'Centro', '31.400-122', 'Belo Horizonte', 'MG', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('José Carlos Siqueira', 'Rua do Músico', '566', 'Próximo ao Centro', 'Segismundo Pereira', '38.400-100', 'Uberlândia', 'MG', true);
INSERT INTO system_people (name, public_place, address_number, complement, neighborhood, cep, city, state, active) values ('Raimunda Braz', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-122', 'Manaus', 'AM', true);


