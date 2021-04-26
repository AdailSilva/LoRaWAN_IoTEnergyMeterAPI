package com.adailsilva.iotenergymeter.api.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.system.model.CustomHeaderHttp;
import com.adailsilva.iotenergymeter.api.system.repository.CustomHeaderHttpRepository;

@Service
public class CustomHeaderHttpService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private CustomHeaderHttpRepository customHeaderHttpRepository;

	private CustomHeaderHttp getCustomHeaderHttpByID(Long id) {

		CustomHeaderHttp customHeaderHttpSave = customHeaderHttpRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return customHeaderHttpSave;
	}

	public CustomHeaderHttp update(CustomHeaderHttp customHeaderHttp, Long id) {

		CustomHeaderHttp customHeaderHttpSave = getCustomHeaderHttpByID(id);

//		BeanUtils.copyProperties(customHeaderHttp, customHeaderHttpSave, "id");
		customHeaderHttpSave.setId(id);
		customHeaderHttpSave.setHeader(customHeaderHttp.getHeader());
		customHeaderHttpSave.setValue(customHeaderHttp.getValue());
		customHeaderHttpSave.setLogin(customHeaderHttp.getLogin());
		customHeaderHttpSave.setPassword(customHeaderHttp.getPassword());
		customHeaderHttpSave.setActive(customHeaderHttp.getActive());

		return customHeaderHttpRepository.save(customHeaderHttpSave);
	}

	public void partialUpdateActive(Long id, Boolean active) {

		CustomHeaderHttp customHeaderHttpSave = getCustomHeaderHttpByID(id);
		customHeaderHttpSave.setActive(active);
		customHeaderHttpRepository.save(customHeaderHttpSave);

	}

}
