package com.adailsilva.iotenergymeter.api.thethingsnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.PayloadFields;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.PayloadFieldsRepository;

@Service
public class PayloadFieldsService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private PayloadFieldsRepository payloadFieldsRepository;

	private PayloadFields getPayloadFieldsByID(Long id) {

		PayloadFields payloadFieldsSave = payloadFieldsRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return payloadFieldsSave;
	}

	public PayloadFields update(PayloadFields payloadFields, Long id) {

		PayloadFields payloadFieldsSave = getPayloadFieldsByID(id);

//		BeanUtils.copyProperties(payloadFields, payloadFieldsSave, "id");
		payloadFieldsSave.setId(id);
		payloadFieldsSave.setAlarmPhaseA(payloadFields.getAlarmPhaseA());
		payloadFieldsSave.setAlarmPhaseB(payloadFields.getAlarmPhaseB());
		payloadFieldsSave.setAlarmPhaseC(payloadFields.getAlarmPhaseC());
		payloadFieldsSave.setCurrentPhaseA(payloadFields.getCurrentPhaseA());
		payloadFieldsSave.setCurrentPhaseB(payloadFields.getCurrentPhaseB());
		payloadFieldsSave.setCurrentPhaseC(payloadFields.getCurrentPhaseC());
		payloadFieldsSave.setEnergyPhaseA(payloadFields.getEnergyPhaseA());
		payloadFieldsSave.setEnergyPhaseB(payloadFields.getEnergyPhaseB());
		payloadFieldsSave.setEnergyPhaseC(payloadFields.getEnergyPhaseC());
		payloadFieldsSave.setFrequencyPhaseA(payloadFields.getFrequencyPhaseA());
		payloadFieldsSave.setFrequencyPhaseB(payloadFields.getFrequencyPhaseB());
		payloadFieldsSave.setFrequencyPhaseC(payloadFields.getFrequencyPhaseC());
		payloadFieldsSave.setPowerFactorPhaseA(payloadFields.getPowerFactorPhaseA());
		payloadFieldsSave.setPowerFactorPhaseB(payloadFields.getPowerFactorPhaseB());
		payloadFieldsSave.setPowerFactorPhaseC(payloadFields.getPowerFactorPhaseC());
		payloadFieldsSave.setPowerPhaseA(payloadFields.getPowerPhaseA());
		payloadFieldsSave.setPowerPhaseB(payloadFields.getPowerPhaseB());
		payloadFieldsSave.setPowerPhaseC(payloadFields.getPowerPhaseC());
		payloadFieldsSave.setVoltagePhaseA(payloadFields.getVoltagePhaseA());
		payloadFieldsSave.setVoltagePhaseB(payloadFields.getVoltagePhaseB());
		payloadFieldsSave.setVoltagePhaseC(payloadFields.getVoltagePhaseC());
		payloadFieldsSave.setTTNRawBody(payloadFieldsSave.gettTNRawBody());

		return payloadFieldsRepository.save(payloadFieldsSave);
	}

}
