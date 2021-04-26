package com.adailsilva.iotenergymeter.api.chirpstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
