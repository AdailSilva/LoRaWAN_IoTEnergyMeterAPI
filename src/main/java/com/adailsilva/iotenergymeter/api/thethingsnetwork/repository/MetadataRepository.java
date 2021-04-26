package com.adailsilva.iotenergymeter.api.thethingsnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.Metadata;
public interface MetadataRepository extends JpaRepository<Metadata, Long> {

}
