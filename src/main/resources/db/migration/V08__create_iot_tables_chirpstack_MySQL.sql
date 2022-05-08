-- MySQL

-- -----------------------------------------------------
-- Schema iotenergymeterapi
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `iotenergymeterapi` ;
--USE `iotenergymeterapi` ;


CREATE TABLE cs_raw_bodies (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  application_id BIGINT NOT NULL,
  application_name VARCHAR(30) NOT NULL,
  device_name VARCHAR(30) NOT NULL,
  dev_eui VARCHAR(30) NOT NULL,
  margin INT NULL,
  external_power_source TINYINT NULL,
  battery_level_unavailable TINYINT NULL,
  battery_level INT NULL,
  adr TINYINT NULL,
  dr TINYINT NULL,
  type VARCHAR(50) NULL,
  error VARCHAR(50) NULL,
  acknowledged TINYINT NULL,
  f_cnt INT NULL,
  f_port INT NULL,
  data VARCHAR(200) NULL,
  object_json VARCHAR(500) NULL,
  confirmed_uplink TINYINT NULL,
  dev_addr VARCHAR(20) NULL,
  gateway_id VARCHAR(30) NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE cs_rx_info (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  gateway_id VARCHAR(30) NOT NULL,
  time VARCHAR(30) NOT NULL,
  time_since_gps_epoch VARCHAR(30) NULL,
  rssi INT NOT NULL,
  lora_snr FLOAT NOT NULL,
  channel INT NOT NULL,
  rf_chain INT NOT NULL,
  board INT NOT NULL,
  antenna INT NOT NULL,
  fine_timestamp_type VARCHAR(30) NOT NULL,
  context VARCHAR(30) NOT NULL,
  uplink_id VARCHAR(30) NOT NULL,
  crc_status VARCHAR(10) NOT NULL,
  cs_raw_bodies_id BIGINT NULL,
  FOREIGN KEY (cs_raw_bodies_id) REFERENCES cs_raw_bodies(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE cs_locations (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  latitude FLOAT NOT NULL,
  longitude FLOAT NOT NULL,
  altitude INT NOT NULL,
  source VARCHAR(30) NOT NULL,
  accuracy INT NOT NULL,
  cs_rx_info_id BIGINT NULL,
  FOREIGN KEY (cs_rx_info_id) REFERENCES cs_rx_info(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE cs_tx_info (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  gateway_id VARCHAR(30) NULL,
  frequency INT NOT NULL,
  power INT NULL,
  modulation VARCHAR(4) NOT NULL,
  board INT NULL,
  antenna INT NULL,
  timing VARCHAR(11) NULL,
  context VARCHAR(30) NULL,
  cs_raw_bodies_id BIGINT NULL,
  FOREIGN KEY (cs_raw_bodies_id) REFERENCES cs_raw_bodies(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE cs_immediately_timing_info (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  cs_tx_info_id BIGINT NULL,
  FOREIGN KEY (cs_tx_info_id) REFERENCES cs_tx_info(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE cs_lora_modulation_info (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  bandwidth INT NOT NULL,
  spreading_factor INT NOT NULL,
  code_rate VARCHAR(3) NULL,
  polarization_inversion TINYINT NOT NULL,  
  cs_tx_info_id BIGINT NULL,
  FOREIGN KEY (cs_tx_info_id) REFERENCES cs_tx_info(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


CREATE TABLE cs_tags (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  company VARCHAR(50) NULL,
  device VARCHAR(50) NULL,
  cs_raw_bodies_id BIGINT NULL,
  FOREIGN KEY (cs_raw_bodies_id) REFERENCES cs_raw_bodies(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

