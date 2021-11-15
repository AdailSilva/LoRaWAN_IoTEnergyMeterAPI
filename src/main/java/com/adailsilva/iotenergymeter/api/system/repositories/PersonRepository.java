package com.adailsilva.iotenergymeter.api.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
