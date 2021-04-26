package com.adailsilva.iotenergymeter.api.thethingsnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.TTNRawBody;

public interface TTNRawBodyRepository extends JpaRepository<TTNRawBody, Long> {

}
