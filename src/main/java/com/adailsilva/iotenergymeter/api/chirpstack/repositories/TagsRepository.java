package com.adailsilva.iotenergymeter.api.chirpstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {

}
