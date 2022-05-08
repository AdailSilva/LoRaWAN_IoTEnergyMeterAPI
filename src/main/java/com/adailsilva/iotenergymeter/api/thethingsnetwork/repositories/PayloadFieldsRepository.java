package com.adailsilva.iotenergymeter.api.thethingsnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.entities.PayloadFields;

public interface PayloadFieldsRepository extends JpaRepository<PayloadFields, Long> {

}
