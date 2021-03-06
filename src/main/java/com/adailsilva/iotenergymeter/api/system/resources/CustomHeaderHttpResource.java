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

import com.adailsilva.iotenergymeter.api.events.ResourceCreatedEvent;
import com.adailsilva.iotenergymeter.api.system.entities.CustomHeaderHttp;
import com.adailsilva.iotenergymeter.api.system.repositories.CustomHeaderHttpRepository;
import com.adailsilva.iotenergymeter.api.system.services.CustomHeaderHttpService;

@RestController
@RequestMapping("/system/customheadershttp")
public class CustomHeaderHttpResource {

	@Autowired
	private CustomHeaderHttpRepository customHeaderHttpRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private CustomHeaderHttpService customHeaderHttpService;

	@PostMapping
	public ResponseEntity<CustomHeaderHttp> create(
			@Valid @RequestBody(required = true) CustomHeaderHttp customHeaderHttp,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		CustomHeaderHttp customHeaderHttpSave = customHeaderHttpRepository.save(customHeaderHttp);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(customHeaderHttpSave, httpServletRequest,
				httpServletResponse, customHeaderHttpSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(customHeaderHttpSave);
	}

	@GetMapping
	public List<CustomHeaderHttp> read() {
		return customHeaderHttpRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomHeaderHttp> readByID(@PathVariable Long id) {
		Optional<CustomHeaderHttp> customHeaderHttpSave = customHeaderHttpRepository.findById(id);
		return customHeaderHttpSave.isPresent() ? ResponseEntity.ok(customHeaderHttpSave.get())
				: ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomHeaderHttp> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) CustomHeaderHttp customHeaderHttp,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		CustomHeaderHttp customHeaderHttpSave = customHeaderHttpService.update(customHeaderHttp, id);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(customHeaderHttpSave, httpServletRequest,
				httpServletResponse, customHeaderHttpSave.getId()));

		return ResponseEntity.ok(customHeaderHttpSave);
	}

	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void partialUpdateActive(@PathVariable Long id, @RequestBody(required = true) Boolean active) {

		customHeaderHttpService.partialUpdateActive(id, active);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		customHeaderHttpRepository.deleteById(id);
	}

}
