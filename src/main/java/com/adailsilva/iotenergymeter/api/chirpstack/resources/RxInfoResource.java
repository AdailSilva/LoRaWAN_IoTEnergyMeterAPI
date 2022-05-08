package com.adailsilva.iotenergymeter.api.chirpstack.resources;

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

import com.adailsilva.iotenergymeter.api.chirpstack.entities.Location;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.RxInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.LocationRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.RxInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.services.RxInfoService;
import com.adailsilva.iotenergymeter.api.events.ResourceCreatedEvent;

@RestController
@RequestMapping("/chirpstack/rxinfo")
public class RxInfoResource {

	@Autowired
	private RxInfoRepository rxInfoRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private RxInfoService rxInfoService;

	@PostMapping
	public ResponseEntity<RxInfo> create(@Valid @RequestBody(required = true) RxInfo rxInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		RxInfo rxInfoSave = rxInfoRepository.save(rxInfo);

		// UPDATES: Foreign keys
		Location location = rxInfoSave.getLocation();
		if (location != null) {
			location.setRxInfo(rxInfoSave);
			locationRepository.save(location);
		}

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(rxInfoSave, httpServletRequest, httpServletResponse, rxInfoSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(rxInfoSave);
	}

	@GetMapping
	public List<RxInfo> read() {
		return rxInfoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<RxInfo> readByID(@PathVariable Long id) {
		Optional<RxInfo> rxInfoSave = rxInfoRepository.findById(id);
		return rxInfoSave.isPresent() ? ResponseEntity.ok(rxInfoSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<RxInfo> update(@PathVariable Long id, @Valid @RequestBody(required = true) RxInfo rxInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		RxInfo rxInfoSave = rxInfoService.update(rxInfo, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(rxInfoSave, httpServletRequest, httpServletResponse, rxInfoSave.getId()));

		return ResponseEntity.ok(rxInfoSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		rxInfoRepository.deleteById(id);
	}

}
