-- MySQL

-- -----------------------------------------------------
-- Schema iotenergymeterapi
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `iotenergymeterapi` ;
--USE `iotenergymeterapi` ;


CREATE TABLE system_registries (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(50) NOT NULL,
  maturitie_date DATE NOT NULL,
  payment_date DATE NULL,
  registry_value DECIMAL(10,2) NOT NULL,
  observation VARCHAR(100) NULL,
  registry_type VARCHAR(10) NOT NULL,
  system_category_id BIGINT NULL,
  system_person_id BIGINT NULL,
  FOREIGN KEY (system_category_id) REFERENCES system_categories(id),
  FOREIGN KEY (system_person_id) REFERENCES system_people(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


-- -----------------------------------------------------
-- Selecting the `iotenergymeterapi` database
-- -----------------------------------------------------
--USE `iotenergymeterapi`;


INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Salário Mensal', '2011-01-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Viajem Sobral', '2010-02-10', '2019-02-10', 100.32, null, 'DESPESA', 2, 5);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Gateway LoRaWAN', '2009-03-10', null, 120, null, 'RECEITA', 3, 1);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('DAE ICMS', '2000-02-10', '2019-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('DAE IPVA', '2001-03-11', null, 200.30, null, 'DESPESA', 3, 7);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Peças Extra', '2007-03-10', '2019-03-10', 1010.32, null, 'RECEITA', 4, 6);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Compra Fios', '2010-01-10', null, 500, null, 'RECEITA', 1, 7);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Uber', '2009-03-10', '2019-03-10', 400.32, null, 'DESPESA', 4, 3);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Despachante', '2008-02-10', null, 123.64, 'Multas', 'DESPESA', 3, 4);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Frete Peças', '2013-01-10', '2019-02-10', 665.33, null, 'RECEITA', 5, 7);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Compra Relés', '1999-02-10', null, 8.32, null, 'DESPESA', 1, 5);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Eletrônicos', '1980-02-10', '2019-02-10', 2100.32, null, 'DESPESA', 5, 4);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Instrumentos', '2000-01-10', null, 1040.32, null, 'DESPESA', 2, 3);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Almoço', '2019-01-10', '2019-01-10', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO system_registries (description, maturitie_date, payment_date, registry_value, observation, registry_type, system_category_id, system_person_id) values ('Lanche', '2019-02-10', null, 10.20, null, 'DESPESA', 5, 1);


