-- MySQL

-- -----------------------------------------------------
-- Schema iotenergymeterapi
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `iotenergymeterapi` ;
--USE `iotenergymeterapi` ;


CREATE TABLE ttn_raw_bodies (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  app_id VARCHAR(36) NOT NULL,
  dev_id VARCHAR(36) NOT NULL,
  hardware_serial VARCHAR(16) NOT NULL,
  port INT NOT NULL,
  counter BIGINT NOT NULL,
  payload_raw VARCHAR(250) NOT NULL,
  downlink_url VARCHAR(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE ttn_payload_fields (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  alarm_phase_a TINYINT NOT NULL,
  alarm_phase_b TINYINT NOT NULL,
  alarm_phase_c TINYINT NOT NULL,
  current_phase_a FLOAT NOT NULL,
  current_phase_b FLOAT NOT NULL,
  current_phase_c FLOAT NOT NULL,
  energy_phase_a FLOAT NOT NULL,
  energy_phase_b FLOAT NOT NULL,
  energy_phase_c FLOAT NOT NULL,
  frequency_phase_a FLOAT NOT NULL,
  frequency_phase_b FLOAT NOT NULL,
  frequency_phase_c FLOAT NOT NULL,
  power_factor_phase_a FLOAT NOT NULL,
  power_factor_phase_b FLOAT NOT NULL,
  power_factor_phase_c FLOAT NOT NULL,
  power_phase_a FLOAT NOT NULL,
  power_phase_b FLOAT NOT NULL,
  power_phase_c FLOAT NOT NULL,
  voltage_phase_a FLOAT NOT NULL,
  voltage_phase_b FLOAT NOT NULL,
  voltage_phase_c FLOAT NOT NULL,
  ttn_raw_bodies_id BIGINT NULL,
  FOREIGN KEY (ttn_raw_bodies_id) REFERENCES ttn_raw_bodies(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE ttn_metadata (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  time VARCHAR(30) NOT NULL,
  frequency FLOAT NOT NULL,
  modulation VARCHAR(4) NOT NULL,
  data_rate VARCHAR(9) NOT NULL,
  coding_rate VARCHAR(3) NOT NULL,
  ttn_raw_bodies_id BIGINT NULL,
  FOREIGN KEY (ttn_raw_bodies_id) REFERENCES ttn_raw_bodies(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE ttn_gateways (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  gtw_id VARCHAR(20) NOT NULL,
  timestamp VARCHAR(10) NOT NULL,
  time VARCHAR(30) NOT NULL,
  channel INT NOT NULL,
  rssi INT NOT NULL,
  snr FLOAT NOT NULL,
  rf_chain INT NOT NULL,
  latitude FLOAT NULL,
  longitude FLOAT NULL,
  altitude INT NULL,
  ttn_metadata_id BIGINT NULL,
  FOREIGN KEY (ttn_metadata_id) REFERENCES ttn_metadata(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
