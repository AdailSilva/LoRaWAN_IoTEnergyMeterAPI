-- MySQL

-- -----------------------------------------------------
-- Schema iotenergymeterapi
-- -----------------------------------------------------
--CREATE SCHEMA IF NOT EXISTS `iotenergymeterapi` ;
--USE `iotenergymeterapi` ;


CREATE TABLE system_users (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(60) NOT NULL,
  active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE system_permissions (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(50) NOT NULL,
  active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE system_user_permission (
  system_user_id BIGINT NOT NULL,
  system_permission_id BIGINT NOT NULL,
  PRIMARY KEY (system_user_id, system_permission_id),
  FOREIGN KEY (system_user_id) REFERENCES system_users(id),
  FOREIGN KEY (system_permission_id) REFERENCES system_permissions(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


-- -----------------------------------------------------
-- Selecting the `iotenergymeterapi` database
-- -----------------------------------------------------
--USE `iotenergymeterapi`;


INSERT INTO system_users (name, email, password, active) values ('Administrador', 'admin@adailsilva.com', '$2a$10$F6YxpPi8AGfMwV8iw8gf3eKUG/ZagxEN9D/ojXxuMkpaJz/FdXqaS', true);
INSERT INTO system_users (name, email, password, active) values ('AdailSilva', 'adailsilva@adailsilva.com', '$2a$10$F6YxpPi8AGfMwV8iw8gf3eKUG/ZagxEN9D/ojXxuMkpaJz/FdXqaS', true);
INSERT INTO system_users (name, email, password, active) values ('Usuário', 'user@adailsilva.com', '$2a$10$F6YxpPi8AGfMwV8iw8gf3eKUG/ZagxEN9D/ojXxuMkpaJz/FdXqaS', true);


-- ROLES
INSERT INTO system_permissions (description, active) values ('ROLE_CREATE_RAWBODY', true);
INSERT INTO system_permissions (description, active) values ('ROLE_READ_RAWBODY', true);
INSERT INTO system_permissions (description, active) values ('ROLE_UPDATE_RAWBODY', true);
INSERT INTO system_permissions (description, active) values ('ROLE_DELETE_RAWBODY', true);

INSERT INTO system_permissions (description, active) values ('ROLE_CREATE_PAYLOADFIELD', true);
INSERT INTO system_permissions (description, active) values ('ROLE_READ_PAYLOADFIELD', true);
INSERT INTO system_permissions (description, active) values ('ROLE_UPDATE_PAYLOADFIELD', true);
INSERT INTO system_permissions (description, active) values ('ROLE_DELETE_PAYLOADFIELD', true);

INSERT INTO system_permissions (description, active) values ('ROLE_CREATE_METADATA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_READ_METADATA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_UPDATE_METADATA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_DELETE_METADATA', true);

INSERT INTO system_permissions (description, active) values ('ROLE_CREATE_GATEWAY', true);
INSERT INTO system_permissions (description, active) values ('ROLE_READ_GATEWAY', true);
INSERT INTO system_permissions (description, active) values ('ROLE_UPDATE_GATEWAY', true);
INSERT INTO system_permissions (description, active) values ('ROLE_DELETE_GATEWAY', true);

INSERT INTO system_permissions (description, active) values ('ROLE_CREATE_CATEGORIA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_READ_CATEGORIA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_UPDATE_CATEGORIA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_DELETE_CATEGORIA', true);

INSERT INTO system_permissions (description, active) values ('ROLE_CREATE_PESSOA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_READ_PESSOA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_UPDATE_PESSOA', true);
INSERT INTO system_permissions (description, active) values ('ROLE_DELETE_PESSOA', true);

INSERT INTO system_permissions (description, active) values ('ROLE_CREATE_LANCAMENTO', true);
INSERT INTO system_permissions (description, active) values ('ROLE_READ_LANCAMENTO', true);
INSERT INTO system_permissions (description, active) values ('ROLE_UPDATE_LANCAMENTO', true);
INSERT INTO system_permissions (description, active) values ('ROLE_DELETE_LANCAMENTO', true);


-- USER: admin
-- RAWBODY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 1);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 2);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 3);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 4);

-- PAYLOADFIELD
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 5);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 6);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 7);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 8);

-- METADATA
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 9);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 10);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 11);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 12);

-- GATEWAY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 13);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 14);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 15);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 16);

-- CATEGORY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 17);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 18);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 19);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 20);

-- PERSON
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 21);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 22);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 23);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 24);

-- REGISTRY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 25);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 26);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 27);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (1, 28);


-- USER: adailsilva
-- RAWBODY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 1);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 2);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 3);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 4);

-- PAYLOADFIELD
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 5);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 6);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 7);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 8);

-- METADATA
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 9);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 10);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 11);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 12);

-- GATEWAY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 13);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 14);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 15);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 16);

-- CATEGORY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 17);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 18);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 19);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 20);

-- PERSON
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 21);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 22);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 23);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 24);

-- REGISTRY
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 25);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 26);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 27);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (2, 28);


-- USER: user
-- RAWBODY
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 1);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 2);
-- INSERT system_INTO user_permission (system_user_id, system_permission_id) values (3, 3);
-- INSERT system_INTO user_permission (system_user_id, system_permission_id) values (3, 4);

-- PAYLOADFIELD
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 5);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 6);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 7);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 8);

-- METADATA
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 9);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 10);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 11);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 12);

-- GATEWAY
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 13);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 14);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 15);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 16);

-- CATEGORY
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 17);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 18);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 19);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 20);

-- PERSON
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 21);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 22);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 23);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 24);

-- REGISTRY
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 25);
INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 26);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 27);
-- INSERT INTO system_user_permission (system_user_id, system_permission_id) values (3, 28);
