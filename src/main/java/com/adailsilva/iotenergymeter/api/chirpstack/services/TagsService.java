package com.adailsilva.iotenergymeter.api.chirpstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.Tags;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.TagsRepository;

@Service
public class TagsService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private TagsRepository tagsRepository;

	private Tags getTagsByID(Long id) {

		Tags tagsSave = tagsRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

		return tagsSave;
	}

	public Tags update(Tags tags, Long id) {

		Tags tagsSave = getTagsByID(id);

//		BeanUtils.copyProperties(tags, tagsSave, "id");
		tagsSave.setId(id);
		tagsSave.setCompany(tags.getCompany());
		tagsSave.setDevice(tags.getDevice());
		tagsSave.setCSRawBody(tagsSave.getCSRawBody());

		return tagsRepository.save(tagsSave);
	}

}
