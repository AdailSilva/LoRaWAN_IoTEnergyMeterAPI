package com.adailsilva.iotenergymeter.api.thethingsnetwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.entities.Metadata;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repositories.MetadataRepository;

@Service
public class MetadataService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private MetadataRepository metadataRepository;

	private Metadata getMetadataByID(Long id) {

		Metadata metadataSave = metadataRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return metadataSave;
	}

	public Metadata update(Metadata metadata, Long id) {

		Metadata metadataSave = getMetadataByID(id);

//		BeanUtils.copyProperties(metadata, metadataSave, "id");
		metadataSave.setId(id);
		metadataSave.setTime(metadata.getTime());
		metadataSave.setFrequency(metadata.getFrequency());
		metadataSave.setModulation(metadata.getModulation());
		metadataSave.setDataRate(metadata.getDataRate());
		metadataSave.setCodingRate(metadata.getCodingRate());
		metadataSave.setGateways(metadataSave.getGateways());
		metadataSave.setTTNRawBody(metadataSave.gettTNRawBody());

		return metadataRepository.save(metadataSave);
	}

}
