package com.adailsilva.iotenergymeter.api.chirpstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.CSRawBody;

public interface CSRawBodyRepository extends JpaRepository<CSRawBody, Long> {

}
