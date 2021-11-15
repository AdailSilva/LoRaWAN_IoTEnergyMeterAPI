-- MySQL

-- -----------------------------------------------------
-- Schema iotenergymeterapi
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `iotenergymeterapi` ;
--USE `iotenergymeterapi` ;


CREATE TABLE system_custom_headers_http (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	header VARCHAR(50) NOT NULL,
	value VARCHAR(50) NOT NULL,
	login VARCHAR(50) NOT NULL,
	password VARCHAR(60) NOT NULL,
	active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


-- -----------------------------------------------------
-- Selecting the `iotenergymeterapi` database
-- -----------------------------------------------------
--USE `iotenergymeterapi`;


INSERT INTO system_custom_headers_http (header, value, login, password, active) values ('IoTEnergyMeter','01115937359','adail101@hotmail.com','$2a$10$PX.wzIc/GrFiWgnR0rx6k.sI5JNMAuquPysv97cLuoLEpnCCSppRC', true);
