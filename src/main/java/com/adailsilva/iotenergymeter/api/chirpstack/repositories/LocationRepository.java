package com.adailsilva.iotenergymeter.api.chirpstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
