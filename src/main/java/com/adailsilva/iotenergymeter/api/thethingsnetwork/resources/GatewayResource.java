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
import com.adailsilva.iotenergymeter.api.thethingsnetwork.repository.GatewayRepository;
import com.adailsilva.iotenergymeter.api.thethingsnetwork.service.GatewayService;

@RestController
@RequestMapping("/thethingsnetwork/gateways")
public class GatewayResource {

	@Autowired
	private GatewayRepository gatewayRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private GatewayService gatewayService;

	@PostMapping
	public ResponseEntity<Gateway> create(@Valid @RequestBody Gateway gateway, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		Gateway gatewaySave = gatewayRepository.save(gateway);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(gatewaySave, httpServletRequest, httpServletResponse, gatewaySave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(gatewaySave);
	}

	@GetMapping
	public List<Gateway> read() {
		return gatewayRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Gateway> readByID(@PathVariable Long id) {
		Optional<Gateway> gatewaySave = gatewayRepository.findById(id);
		return gatewaySave.isPresent() ? ResponseEntity.ok(gatewaySave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Gateway> update(@PathVariable Long id, @Valid @RequestBody Gateway gateway,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Gateway gatewaySave = gatewayService.update(gateway, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(gatewaySave, httpServletRequest, httpServletResponse, gatewaySave.getId()));

		return ResponseEntity.ok(gatewaySave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		gatewayRepository.deleteById(id);
	}

}
