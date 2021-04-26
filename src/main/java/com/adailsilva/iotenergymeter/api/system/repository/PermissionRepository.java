package com.adailsilva.iotenergymeter.api.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
