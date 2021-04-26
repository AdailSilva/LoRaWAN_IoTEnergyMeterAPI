package com.adailsilva.iotenergymeter.api.chirpstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.chirpstack.model.LoRaModulationInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repository.LoRaModulationInfoRepository;

@Service
public class LoRaModulationInfoService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private LoRaModulationInfoRepository loRaModulationInfoRepository;

	private LoRaModulationInfo getLoRaModulationInfoByID(Long id) {

		LoRaModulationInfo loRaModulationInfoSave = loRaModulationInfoRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return loRaModulationInfoSave;
	}

	public LoRaModulationInfo update(LoRaModulationInfo loRaModulationInfo, Long id) {

		LoRaModulationInfo loRaModulationInfoSave = getLoRaModulationInfoByID(id);

//		BeanUtils.copyProperties(loRaModulationInfo, loRaModulationInfoSave, "id");
		loRaModulationInfoSave.setId(id);
		loRaModulationInfoSave.setBandwidth(loRaModulationInfo.getBandwidth());
		loRaModulationInfoSave.setSpreadingFactor(loRaModulationInfo.getSpreadingFactor());
		loRaModulationInfoSave.setCodeRate(loRaModulationInfo.getCodeRate());
		loRaModulationInfoSave.setPolarizationInversion(loRaModulationInfo.getPolarizationInversion());
		loRaModulationInfoSave.setTxInfo(loRaModulationInfoSave.getTxInfo());

		return loRaModulationInfoRepository.save(loRaModulationInfoSave);
	}

}
