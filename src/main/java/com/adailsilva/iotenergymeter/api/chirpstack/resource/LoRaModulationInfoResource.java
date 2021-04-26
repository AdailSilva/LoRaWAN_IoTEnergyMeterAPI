package com.adailsilva.iotenergymeter.api.chirpstack.resource;

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

import com.adailsilva.iotenergymeter.api.chirpstack.model.LoRaModulationInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repository.LoRaModulationInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.service.LoRaModulationInfoService;
import com.adailsilva.iotenergymeter.api.event.ResourceCreatedEvent;

@RestController
@RequestMapping("/chirpstack/loramodulationinfo")
public class LoRaModulationInfoResource {

	@Autowired
	private LoRaModulationInfoRepository loRaModulationInfoRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private LoRaModulationInfoService loRaModulationInfoService;

	@PostMapping
	public ResponseEntity<LoRaModulationInfo> create(
			@Valid @RequestBody(required = true) LoRaModulationInfo loRaModulationInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		LoRaModulationInfo loRaModulationInfoSave = loRaModulationInfoRepository.save(loRaModulationInfo);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(loRaModulationInfoSave, httpServletRequest,
				httpServletResponse, loRaModulationInfoSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(loRaModulationInfoSave);
	}

	@GetMapping
	public List<LoRaModulationInfo> read() {
		return loRaModulationInfoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<LoRaModulationInfo> readByID(@PathVariable Long id) {
		Optional<LoRaModulationInfo> loRaModulationInfoSave = loRaModulationInfoRepository.findById(id);
		return loRaModulationInfoSave.isPresent() ? ResponseEntity.ok(loRaModulationInfoSave.get())
				: ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<LoRaModulationInfo> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) LoRaModulationInfo loRaModulationInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		LoRaModulationInfo loRaModulationInfoSave = loRaModulationInfoService.update(loRaModulationInfo, id);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(loRaModulationInfoSave, httpServletRequest,
				httpServletResponse, loRaModulationInfoSave.getId()));

		return ResponseEntity.ok(loRaModulationInfoSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		loRaModulationInfoRepository.deleteById(id);
	}

}
