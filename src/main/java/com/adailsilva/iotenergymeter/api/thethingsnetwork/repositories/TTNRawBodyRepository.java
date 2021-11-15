package com.adailsilva.iotenergymeter.api.thethingsnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.entities.TTNRawBody;

public interface TTNRawBodyRepository extends JpaRepository<TTNRawBody, Long> {

}
