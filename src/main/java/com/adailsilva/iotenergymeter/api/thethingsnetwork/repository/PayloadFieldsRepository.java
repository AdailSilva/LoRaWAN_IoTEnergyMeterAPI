package com.adailsilva.iotenergymeter.api.thethingsnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.PayloadFields;

public interface PayloadFieldsRepository extends JpaRepository<PayloadFields, Long> {

}
