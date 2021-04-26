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
import com.adailsilva.iotenergymeter.api.system.model.Registry;
import com.adailsilva.iotenergymeter.api.system.repository.RegistryRepository;
import com.adailsilva.iotenergymeter.api.system.service.RegistryService;
@RestController
@RequestMapping("/system/registries")
public class RegistryResource {

	@Autowired
	private RegistryRepository registryRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private RegistryService registryService;

	@PostMapping
	public ResponseEntity<Registry> create(@Valid @RequestBody(required = true) Registry registry,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Registry registrySave = registryService.activePersonVerification(registry);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(registrySave, httpServletRequest, httpServletResponse, registrySave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(registrySave);
	}

	@GetMapping
	public List<Registry> read() {
		return registryRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Registry> readByID(@PathVariable Long id) {
		Optional<Registry> registrySave = registryRepository.findById(id);
		return registrySave.isPresent() ? ResponseEntity.ok(registrySave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Registry> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) Registry registry, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		Registry registrySave = registryService.update(registry, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(registrySave, httpServletRequest, httpServletResponse, registrySave.getId()));

		return ResponseEntity.ok(registrySave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		registryRepository.deleteById(id);
	}

}
