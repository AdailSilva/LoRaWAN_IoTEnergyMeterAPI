package com.adailsilva.iotenergymeter.api.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.entities.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
