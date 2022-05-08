-- MySQL

-- -----------------------------------------------------
-- Schema iotenergymeterapi
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `iotenergymeterapi` ;
--USE `iotenergymeterapi` ;


CREATE TABLE system_categories (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


-- -----------------------------------------------------
-- Selecting the `iotenergymeterapi` database
-- -----------------------------------------------------
--USE `iotenergymeterapi`;


INSERT INTO system_categories (name) VALUES ('Alimentação');
INSERT INTO system_categories (name) VALUES ('Farmácia');
INSERT INTO system_categories (name) VALUES ('Lazer');
INSERT INTO system_categories (name) VALUES ('Outras Despesas');
INSERT INTO system_categories (name) VALUES ('Supermercado');


