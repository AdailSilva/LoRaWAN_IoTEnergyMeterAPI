package com.adailsilva.iotenergymeter.api.thethingsnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.Gateway;

public interface GatewayRepository extends JpaRepository<Gateway, Long> {

}
