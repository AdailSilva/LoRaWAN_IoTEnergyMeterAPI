package com.adailsilva.iotenergymeter.api.chirpstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.RxInfo;

public interface RxInfoRepository extends JpaRepository<RxInfo, Long> {
	
}
