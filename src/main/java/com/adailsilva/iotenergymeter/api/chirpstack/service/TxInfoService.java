package com.adailsilva.iotenergymeter.api.chirpstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.chirpstack.model.TxInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repository.TxInfoRepository;

@Service
public class TxInfoService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private TxInfoRepository txInfoRepository;

	private TxInfo getTxInfoByID(Long id) {

		TxInfo txInfoSave = txInfoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

		return txInfoSave;
	}

	public TxInfo update(TxInfo txInfo, Long id) {

		TxInfo txInfoSave = getTxInfoByID(id);

//		BeanUtils.copyProperties(txInfo, txInfoSave, "id");
		txInfoSave.setId(id);
		txInfoSave.setFrequency(txInfo.getFrequency());
		txInfoSave.setModulation(txInfo.getModulation());
		txInfoSave.setLoRaModulationInfo(txInfoSave.getLoRaModulationInfo());
		txInfoSave.setGatewayID(txInfo.getGatewayID());
		txInfoSave.setCSRawBody(txInfoSave.getcSRawBody());

		return txInfoRepository.save(txInfoSave);
	}

}
