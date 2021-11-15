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
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.LocationRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.services.LocationService;
import com.adailsilva.iotenergymeter.api.events.ResourceCreatedEvent;

@RestController
@RequestMapping("/chirpstack/locations")
public class LocationResource {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private LocationService locationService;

	@PostMapping
	public ResponseEntity<Location> create(@Valid @RequestBody(required = true) Location location,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Location locationSave = locationRepository.save(location);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(locationSave, httpServletRequest, httpServletResponse, locationSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(locationSave);
	}

	@GetMapping
	public List<Location> read() {
		return locationRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Location> readByID(@PathVariable Long id) {
		Optional<Location> locationSave = locationRepository.findById(id);
		return locationSave.isPresent() ? ResponseEntity.ok(locationSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Location> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) Location location, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		Location locationSave = locationService.update(location, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(locationSave, httpServletRequest, httpServletResponse, locationSave.getId()));

		return ResponseEntity.ok(locationSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		locationRepository.deleteById(id);
	}

}
