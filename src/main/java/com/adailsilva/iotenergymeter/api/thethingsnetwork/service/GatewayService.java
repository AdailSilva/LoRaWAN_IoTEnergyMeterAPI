package com.adailsilva.iotenergymeter.api.thethingsnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.Gateway;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.GatewayRepository;

@Service
public class GatewayService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private GatewayRepository gatewayRepository;

	private Gateway getGatewayByID(Long id) {

		Gateway gatewaySave = gatewayRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

		return gatewaySave;
	}

	public Gateway update(Gateway gateway, Long id) {

		Gateway gatewaySave = getGatewayByID(id);

//		BeanUtils.copyProperties(gateway, gatewaySave, "id");
		gatewaySave.setId(id);
		gatewaySave.setGtwID(gateway.getGtwID());
		gatewaySave.setTimestamp(gateway.getTimestamp());
		gatewaySave.setTime(gateway.getTime());
		gatewaySave.setChannel(gateway.getChannel());
		gatewaySave.setRssi(gateway.getRssi());
		gatewaySave.setSnr(gateway.getSnr());
		gatewaySave.setRfChain(gateway.getRfChain());
		gatewaySave.setLatitude(gateway.getLatitude());
		gatewaySave.setLongitude(gateway.getLongitude());
		gatewaySave.setAltitude(gateway.getAltitude());
		gatewaySave.setMetadata(gatewaySave.getMetadata());

		return gatewayRepository.save(gatewaySave);
	}

}
