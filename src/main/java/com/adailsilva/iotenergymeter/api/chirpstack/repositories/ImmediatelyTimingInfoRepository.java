package com.adailsilva.iotenergymeter.api.chirpstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.ImmediatelyTimingInfo;

public interface ImmediatelyTimingInfoRepository extends JpaRepository<ImmediatelyTimingInfo, Long> {

}
