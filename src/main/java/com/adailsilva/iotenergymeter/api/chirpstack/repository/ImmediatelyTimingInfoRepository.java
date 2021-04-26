package com.adailsilva.iotenergymeter.api.chirpstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.model.ImmediatelyTimingInfo;

public interface ImmediatelyTimingInfoRepository extends JpaRepository<ImmediatelyTimingInfo, Long> {

}
