package com.adailsilva.iotenergymeter.api.thethingsnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.entities.Gateway;

public interface GatewayRepository extends JpaRepository<Gateway, Long> {

}
