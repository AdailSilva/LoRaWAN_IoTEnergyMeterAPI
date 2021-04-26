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
import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.Gateway;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.Metadata;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.PayloadFields;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.model.TTNRawBody;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.GatewayRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.MetadataRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.PayloadFieldsRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.TTNRawBodyRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.service.TTNRawBodyService;
@RestController
@RequestMapping("/thethingsnetwork/ttnrawbodies")
public class TTNRawBodyResource {

	@Autowired
	private TTNRawBodyRepository tTNRawBodyRepository;

	@Autowired
	private PayloadFieldsRepository payloadFieldsRepository;

	@Autowired
	private MetadataRepository metadataRepository;

	@Autowired
	private GatewayRepository gatewayRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private TTNRawBodyService tTNRawBodyService;

	@PostMapping
	public ResponseEntity<TTNRawBody> create(@Valid @RequestBody TTNRawBody tTNRawBody,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		TTNRawBody tTNRawBodySave = tTNRawBodyRepository.save(tTNRawBody);

		// UPDATES: Foreign keys
		PayloadFields payloadFields = tTNRawBodySave.getPayloadFields();
		if (payloadFields != null) {
			payloadFields.setTTNRawBody(tTNRawBodySave);
			payloadFieldsRepository.save(payloadFields);
		}

		Metadata metadata = tTNRawBodySave.getMetadata();
		if (metadata != null) {
			metadata.setTTNRawBody(tTNRawBodySave);
			metadataRepository.save(metadata);
		}

		List<Gateway> gateways = tTNRawBodySave.getMetadata().getGateways();
		if (gateways != null) {
			for (int i = 0; i < gateways.size(); i++) {
				gateways.get(i).setMetadata(tTNRawBodySave.getMetadata());
			}
			gatewayRepository.saveAll(gateways);
		}

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(tTNRawBodySave, httpServletRequest,
				httpServletResponse, tTNRawBodySave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(tTNRawBodySave);
	}

	@GetMapping
	public List<TTNRawBody> read() {
		return tTNRawBodyRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TTNRawBody> readByID(@PathVariable Long id) {
		Optional<TTNRawBody> tTNRawBodySave = tTNRawBodyRepository.findById(id);
		return tTNRawBodySave.isPresent() ? ResponseEntity.ok(tTNRawBodySave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<TTNRawBody> update(@PathVariable Long id, @Valid @RequestBody TTNRawBody tTNRawBody,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		TTNRawBody tTNRawBodySave = tTNRawBodyService.update(tTNRawBody, id);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(tTNRawBodySave, httpServletRequest,
				httpServletResponse, tTNRawBodySave.getId()));

		return ResponseEntity.ok(tTNRawBodySave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tTNRawBodyRepository.deleteById(id);
	}

}
