package com.adailsilva.iotenergymeter.api.chirpstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.chirpstack.entities.ImmediatelyTimingInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.ImmediatelyTimingInfoRepository;

@Service
public class ImmediatelyTimingInfoService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private ImmediatelyTimingInfoRepository immediatelyTimingInfoRepository;

	private ImmediatelyTimingInfo getImmediatelyTimingInfoByID(Long id) {

		ImmediatelyTimingInfo immediatelyTimingInfoSave = immediatelyTimingInfoRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return immediatelyTimingInfoSave;
	}

	public ImmediatelyTimingInfo update(ImmediatelyTimingInfo immediatelyTimingInfo, Long id) {

		ImmediatelyTimingInfo immediatelyTimingInfoSave = getImmediatelyTimingInfoByID(id);

//		BeanUtils.copyProperties(immediatelyTimingInfo, immediatelyTimingInfoSave, "id");
		immediatelyTimingInfoSave.setId(id);
		immediatelyTimingInfoSave.setTxInfo(immediatelyTimingInfoSave.getTxInfo());

		return immediatelyTimingInfoRepository.save(immediatelyTimingInfoSave);
	}

}
