package com.adailsilva.iotenergymeter.api.chirpstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.CSRawBody;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.CSRawBodyRepository;

@Service
public class CSRawBodyService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private CSRawBodyRepository cSRawBodyRepository;

	private CSRawBody getCSRawBodyByID(Long id) {

		CSRawBody cSRawBodySave = cSRawBodyRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return cSRawBodySave;
	}

	public CSRawBody update(CSRawBody cSRawBody, Long id) {

		CSRawBody cSRawBodySave = getCSRawBodyByID(id);

//		BeanUtils.copyProperties(cSRawBody, cSRawBodySave, "id");
		cSRawBodySave.setId(id);
		cSRawBodySave.setApplicationID(cSRawBody.getApplicationID());
		cSRawBodySave.setApplicationName(cSRawBody.getApplicationName());
		cSRawBodySave.setDeviceName(cSRawBody.getDeviceName());
		cSRawBodySave.setDevEUI(cSRawBody.getDevEUI());
		cSRawBodySave.setRxInfo(cSRawBodySave.getRxInfo());
		cSRawBodySave.setTxInfo(cSRawBodySave.getTxInfo());
		cSRawBodySave.setAdr(cSRawBody.getAdr());
		cSRawBodySave.setDr(cSRawBody.getDr());
		cSRawBodySave.setFCnt(cSRawBody.getFCnt());
		cSRawBodySave.setFPort(cSRawBody.getFPort());
		cSRawBodySave.setData(cSRawBody.getData());
		cSRawBodySave.setObjectJSON(cSRawBody.getObjectJSON());
		cSRawBodySave.setTags(cSRawBodySave.getTags());
		cSRawBodySave.setConfirmedUplink(cSRawBody.getConfirmedUplink());
		cSRawBodySave.setDevAddr(cSRawBody.getDevAddr());
		cSRawBodySave.setGatewayID(cSRawBody.getGatewayID());

		return cSRawBodyRepository.save(cSRawBodySave);
	}

}
