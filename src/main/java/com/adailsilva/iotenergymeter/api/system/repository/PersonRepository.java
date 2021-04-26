package com.adailsilva.iotenergymeter.api.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
