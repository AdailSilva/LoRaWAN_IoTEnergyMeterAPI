package com.adailsilva.iotenergymeter.api.chirpstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.model.CSRawBody;

public interface CSRawBodyRepository extends JpaRepository<CSRawBody, Long> {

}
