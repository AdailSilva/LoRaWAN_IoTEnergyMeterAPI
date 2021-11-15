package com.adailsilva.iotenergymeter.api.chirpstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.RxInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.RxInfoRepository;

@Service
public class RxInfoService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private RxInfoRepository rxInfoRepository;

	private RxInfo getRxInfoByID(Long id) {

		RxInfo rxInfoSave = rxInfoRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

		return rxInfoSave;
	}

	public RxInfo update(RxInfo rxInfo, Long id) {

		RxInfo rxInfoSave = getRxInfoByID(id);

//		BeanUtils.copyProperties(rxInfo, rxInfoSave, "id");
		rxInfoSave.setId(id);
		rxInfoSave.setGatewayID(rxInfo.getGatewayID());
		rxInfoSave.setTime(rxInfo.getTime());
		rxInfoSave.setTimeSinceGPSEpoch(rxInfo.getTimeSinceGPSEpoch());
		rxInfoSave.setRssi(rxInfo.getRssi());
		rxInfoSave.setLoRaSNR(rxInfo.getLoRaSNR());
		rxInfoSave.setChannel(rxInfo.getChannel());
		rxInfoSave.setRfChain(rxInfo.getRfChain());
		rxInfoSave.setBoard(rxInfo.getBoard());
		rxInfoSave.setAntenna(rxInfo.getAntenna());
		rxInfoSave.setLocation(rxInfoSave.getLocation());
		rxInfoSave.setFineTimestampType(rxInfo.getFineTimestampType());
		rxInfoSave.setContext(rxInfo.getContext());
		rxInfoSave.setUplinkID(rxInfo.getUplinkID());
		rxInfoSave.setCrcStatus(rxInfo.getCrcStatus());
		rxInfoSave.setCSRawBody(rxInfoSave.getcSRawBody());

		return rxInfoRepository.save(rxInfoSave);
	}

}
