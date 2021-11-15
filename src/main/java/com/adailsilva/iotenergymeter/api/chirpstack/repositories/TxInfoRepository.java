package com.adailsilva.iotenergymeter.api.chirpstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.TxInfo;

public interface TxInfoRepository extends JpaRepository<TxInfo, Long> {

}
