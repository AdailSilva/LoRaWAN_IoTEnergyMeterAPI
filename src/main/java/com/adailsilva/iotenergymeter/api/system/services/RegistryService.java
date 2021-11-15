package com.adailsilva.iotenergymeter.api.system.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.system.entities.Person;
import com.adailsilva.iotenergymeter.api.system.entities.Registry;
import com.adailsilva.iotenergymeter.api.system.repositories.PersonRepository;
import com.adailsilva.iotenergymeter.api.system.repositories.RegistryRepository;
import com.adailsilva.iotenergymeter.api.system.services.exceptions.NonexistentOrInactivePersonException;

@Service
public class RegistryService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private RegistryRepository registryRepository;

	public Registry activePersonVerification(Registry registry) {

		Optional<Person> personSave = personRepository.findById(registry.getPerson().getId());

		if (personSave == null || personSave.get().isInactive()) {
			throw new NonexistentOrInactivePersonException();
		}

		return registryRepository.save(registry);
	}

	private Registry getRegistryByID(Long id) {

		Registry registrySave = registryRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return registrySave;
	}

	public Registry update(Registry registry, Long id) {

		Registry registrySave = getRegistryByID(id);

//		BeanUtils.copyProperties(registry, registrySave, "id");
		registrySave.setId(id);
		registrySave.setDescription(registry.getDescription());
		registrySave.setMaturitieDate(registry.getMaturitieDate());
		registrySave.setPaymentDate(registry.getPaymentDate());
		registrySave.setRegistryValue(registry.getRegistryValue());
		registrySave.setObservation(registry.getObservation());
		registrySave.setRegistryType(registry.getRegistryType());
		registrySave.setCategory(registry.getCategory());
		registrySave.setPerson(registry.getPerson());

		return registryRepository.save(registrySave);
	}

}
