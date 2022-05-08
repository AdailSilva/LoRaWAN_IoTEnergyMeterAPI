package com.adailsilva.iotenergymeter.api.chirpstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.LoRaModulationInfo;

public interface LoRaModulationInfoRepository extends JpaRepository<LoRaModulationInfo, Long> {

}
