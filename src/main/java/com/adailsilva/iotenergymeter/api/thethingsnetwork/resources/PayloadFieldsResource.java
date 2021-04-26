package com.adailsilva.iotenergymeter.api.thethingsnetwork.resources;

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
import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.PayloadFields;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.PayloadFieldsRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.service.PayloadFieldsService;

@RestController
@RequestMapping("/thethingsnetwork/payloadfields")
public class PayloadFieldsResource {

	@Autowired
	private PayloadFieldsRepository payloadFieldsRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private PayloadFieldsService payloadFieldsService;

	@PostMapping
	public ResponseEntity<PayloadFields> create(@Valid @RequestBody PayloadFields payloadFields,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		PayloadFields payloadFieldsSave = payloadFieldsRepository.save(payloadFields);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(payloadFieldsSave, httpServletRequest,
				httpServletResponse, payloadFieldsSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(payloadFieldsSave);
	}

	@GetMapping
	public List<PayloadFields> read() {
		return payloadFieldsRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PayloadFields> readByID(@PathVariable Long id) {
		Optional<PayloadFields> payloadFieldsSave = payloadFieldsRepository.findById(id);
		return payloadFieldsSave.isPresent() ? ResponseEntity.ok(payloadFieldsSave.get())
				: ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<PayloadFields> update(@PathVariable Long id, @Valid @RequestBody PayloadFields payloadFields,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		PayloadFields payloadFieldsSave = payloadFieldsService.update(payloadFields, id);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(payloadFieldsSave, httpServletRequest,
				httpServletResponse, payloadFieldsSave.getId()));

		return ResponseEntity.ok(payloadFieldsSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		payloadFieldsRepository.deleteById(id);
	}

}
