package com.adailsilva.iotenergymeter.api.chirpstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.chirpstack.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {

}
