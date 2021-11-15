package com.adailsilva.iotenergymeter.api.thethingsnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.entities.Metadata;
public interface MetadataRepository extends JpaRepository<Metadata, Long> {

}
