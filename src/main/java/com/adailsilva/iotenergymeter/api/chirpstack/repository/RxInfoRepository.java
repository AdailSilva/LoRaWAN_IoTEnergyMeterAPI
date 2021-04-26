package com.adailsilva.iotenergymeter.api.chirpstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.model.RxInfo;

public interface RxInfoRepository extends JpaRepository<RxInfo, Long> {
	
}
