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

import com.adailsilva.iotenergymeter.api.chirpstack.model.ImmediatelyTimingInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repository.ImmediatelyTimingInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.service.ImmediatelyTimingInfoService;
import com.adailsilva.iotenergymeter.api.event.ResourceCreatedEvent;

@RestController
@RequestMapping("/chirpstack/immediatelytiminginfo")
public class ImmediatelyTimingInfoResource {

	@Autowired
	private ImmediatelyTimingInfoRepository immediatelyTimingInfoRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private ImmediatelyTimingInfoService immediatelyTimingInfoService;

	@PostMapping
	public ResponseEntity<ImmediatelyTimingInfo> create(
			@Valid @RequestBody(required = true) ImmediatelyTimingInfo immediatelyTimingInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ImmediatelyTimingInfo immediatelyTimingInfoSave = immediatelyTimingInfoRepository.save(immediatelyTimingInfo);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(immediatelyTimingInfoSave, httpServletRequest,
				httpServletResponse, immediatelyTimingInfoSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(immediatelyTimingInfoSave);
	}

	@GetMapping
	public List<ImmediatelyTimingInfo> read() {
		return immediatelyTimingInfoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ImmediatelyTimingInfo> readByID(@PathVariable Long id) {
		Optional<ImmediatelyTimingInfo> immediatelyTimingInfoSave = immediatelyTimingInfoRepository.findById(id);
		return immediatelyTimingInfoSave.isPresent() ? ResponseEntity.ok(immediatelyTimingInfoSave.get())
				: ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ImmediatelyTimingInfo> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) ImmediatelyTimingInfo immediatelyTimingInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		ImmediatelyTimingInfo immediatelyTimingInfoSave = immediatelyTimingInfoService.update(immediatelyTimingInfo,
				id);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(immediatelyTimingInfoSave, httpServletRequest,
				httpServletResponse, immediatelyTimingInfoSave.getId()));

		return ResponseEntity.ok(immediatelyTimingInfoSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		immediatelyTimingInfoRepository.deleteById(id);
	}

}
