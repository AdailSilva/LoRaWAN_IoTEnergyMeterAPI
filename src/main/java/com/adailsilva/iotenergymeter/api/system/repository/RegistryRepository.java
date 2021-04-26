package com.adailsilva.iotenergymeter.api.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.model.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
