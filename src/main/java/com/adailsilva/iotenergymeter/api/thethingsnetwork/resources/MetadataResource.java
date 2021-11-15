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

import com.adailsilva.iotenergymeter.api.events.ResourceCreatedEvent;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.entities.Gateway;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.entities.Metadata;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repositories.GatewayRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repositories.MetadataRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.services.MetadataService;

@RestController
@RequestMapping("/thethingsnetwork/metadata")
public class MetadataResource {

	@Autowired
	private MetadataRepository metadataRepository;

	@Autowired
	private GatewayRepository gatewayRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private MetadataService metadataService;

	@PostMapping
	public ResponseEntity<Metadata> create(@Valid @RequestBody Metadata metadata, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		Metadata metadataSave = metadataRepository.save(metadata);

		// UPDATES: Foreign keys
		List<Gateway> gateways = metadataSave.getGateways();
		if (gateways != null) {
			for (int i = 0; i < gateways.size(); i++) {
				gateways.get(i).setMetadata(metadataSave);
			}
			gatewayRepository.saveAll(gateways);
		}

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(metadataSave, httpServletRequest, httpServletResponse, metadataSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(metadataSave);
	}

	@GetMapping
	public List<Metadata> read() {
		return metadataRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Metadata> readByID(@PathVariable Long id) {
		Optional<Metadata> metadataSave = metadataRepository.findById(id);
		return metadataSave.isPresent() ? ResponseEntity.ok(metadataSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Metadata> update(@PathVariable Long id, @Valid @RequestBody Metadata metadata,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Metadata metadataSave = metadataService.update(metadata, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(metadataSave, httpServletRequest, httpServletResponse, metadataSave.getId()));

		return ResponseEntity.ok(metadataSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		metadataRepository.deleteById(id);
	}

}
