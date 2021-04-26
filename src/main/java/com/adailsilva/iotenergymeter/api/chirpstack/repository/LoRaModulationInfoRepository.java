package com.adailsilva.iotenergymeter.api.chirpstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.model.LoRaModulationInfo;

public interface LoRaModulationInfoRepository extends JpaRepository<LoRaModulationInfo, Long> {

}
