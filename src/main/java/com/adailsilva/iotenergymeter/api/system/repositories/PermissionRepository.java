package com.adailsilva.iotenergymeter.api.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
