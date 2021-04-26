package com.adailsilva.iotenergymeter.api.thethingsnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.TTNRawBody;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.TTNRawBodyRepository;

@Service
public class TTNRawBodyService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private TTNRawBodyRepository tTNRawBodyRepository;

	private TTNRawBody getTTNRawBodyByID(Long id) {

		TTNRawBody tTNRawBodySave = tTNRawBodyRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return tTNRawBodySave;
	}

	public TTNRawBody update(TTNRawBody tTNRawBody, Long id) {

		TTNRawBody tTNRawBodySave = getTTNRawBodyByID(id);

//		BeanUtils.copyProperties(tTNRawBody, tTNRawBodySave, "id");
		tTNRawBodySave.setId(id);
		tTNRawBodySave.setAppID(tTNRawBody.getAppID());
		tTNRawBodySave.setDevID(tTNRawBody.getDevID());
		tTNRawBodySave.setHardwareSerial(tTNRawBody.getHardwareSerial());
		tTNRawBodySave.setPort(tTNRawBody.getPort());
		tTNRawBodySave.setCounter(tTNRawBody.getCounter());
		tTNRawBodySave.setPayloadRaw(tTNRawBody.getPayloadRaw());
		tTNRawBodySave.setPayloadFields(tTNRawBodySave.getPayloadFields());
		tTNRawBodySave.setMetadata(tTNRawBodySave.getMetadata());
		tTNRawBodySave.setDownlinkURL(tTNRawBody.getDownlinkURL());

		return tTNRawBodyRepository.save(tTNRawBodySave);
	}

}
