package com.adailsilva.iotenergymeter.api.system.resources;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adailsilva.iotenergymeter.api.event.ResourceCreatedEvent;
import com.adailsilva.iotenergymeter.api.system.model.Person;
import com.adailsilva.iotenergymeter.api.system.repository.PersonRepository;
import com.adailsilva.iotenergymeter.api.system.service.PersonService;

@RestController
@RequestMapping("/system/people")
public class PersonResource {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private PersonService personService;

	@PostMapping
	public ResponseEntity<Person> create(@Valid @RequestBody(required = true) Person person,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Person personSave = personRepository.save(person);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(personSave, httpServletRequest, httpServletResponse, personSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(personSave);
	}

	@GetMapping
	public List<Person> read() {
		return personRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> readByID(@PathVariable Long id) {
		Optional<Person> personSave = personRepository.findById(id);
		return personSave.isPresent() ? ResponseEntity.ok(personSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody(required = true) Person person,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Person personSave = personService.update(person, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(personSave, httpServletRequest, httpServletResponse, personSave.getId()));

		return ResponseEntity.ok(personSave);
	}

	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void partialUpdateActive(@PathVariable Long id, @RequestBody(required = true) Boolean active) {

		personService.partialUpdateActive(id, active);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		personRepository.deleteById(id);
	}

}
