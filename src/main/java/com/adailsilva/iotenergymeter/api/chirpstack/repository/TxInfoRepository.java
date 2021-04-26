package com.adailsilva.iotenergymeter.api.chirpstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.model.TxInfo;

public interface TxInfoRepository extends JpaRepository<TxInfo, Long> {

}
