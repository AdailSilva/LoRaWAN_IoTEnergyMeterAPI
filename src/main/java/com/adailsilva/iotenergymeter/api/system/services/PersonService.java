package com.adailsilva.iotenergymeter.api.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.system.entities.Person;
import com.adailsilva.iotenergymeter.api.system.repositories.PersonRepository;

@Service
public class PersonService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private PersonRepository personRepository;

	private Person getPersonByID(Long id) {

		Person personSave = personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

		return personSave;
	}

	public Person update(Person person, Long id) {

		Person personSave = getPersonByID(id);

//		BeanUtils.copyProperties(person, personSave, "id");
		personSave.setId(id);
		personSave.setName(person.getName());
		personSave.setAddress(person.getAddress());
		personSave.setActive(person.getActive());

		return personRepository.save(personSave);
	}

	public void partialUpdateActive(Long id, Boolean active) {

		Person personSave = getPersonByID(id);
		personSave.setActive(active);
		personRepository.save(personSave);

	}

}
