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

import com.adailsilva.iotenergymeter.api.chirpstack.entities.CSRawBody;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.LoRaModulationInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.Location;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.RxInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.Tags;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.TxInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.CSRawBodyRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.LoRaModulationInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.LocationRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.RxInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.TagsRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.TxInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.services.CSRawBodyService;
import com.adailsilva.iotenergymeter.api.events.ResourceCreatedEvent;

@RestController
@RequestMapping("/chirpstack/csrawbodies")
public class CSRawBodyResource {

	@Autowired
	private CSRawBodyRepository cSRawBodyRepository;

	@Autowired
	private RxInfoRepository rxInfoRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private TagsRepository tagsInfoRepository;

	@Autowired
	private TxInfoRepository txInfoRepository;

	@Autowired
	private LoRaModulationInfoRepository loRaModulationInfoRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private CSRawBodyService cSRawBodyService;

	@PostMapping
	public ResponseEntity<CSRawBody> create(@Valid @RequestBody(required = true) CSRawBody cSRawBody,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		CSRawBody cSRawBodySave = cSRawBodyRepository.save(cSRawBody);

		// UPDATES: Foreign keys
		List<RxInfo> rxInfos = cSRawBodySave.getRxInfo();
		if (rxInfos != null) {
			for (int i = 0; i < rxInfos.size(); i++) {
				rxInfos.get(i).setCSRawBody(cSRawBodySave);
			}
			rxInfoRepository.saveAll(rxInfos);
		}

		for (int i = 0; i < rxInfos.size(); i++) {
			Location location = cSRawBodySave.getRxInfo().get(i).getLocation();
			if (location != null) {
				location.setRxInfo(cSRawBodySave.getRxInfo().get(i));
				locationRepository.save(location);
			}
		}

		Tags tags = cSRawBodySave.getTags();
		if (tags != null) {
			tags.setCSRawBody(cSRawBodySave);
			tagsInfoRepository.save(tags);
		}

		TxInfo txInfo = cSRawBodySave.getTxInfo();
		if (txInfo != null) {
			txInfo.setCSRawBody(cSRawBodySave);
			txInfoRepository.save(txInfo);
		}

		LoRaModulationInfo loRaModulationInfo = cSRawBodySave.getTxInfo().getLoRaModulationInfo();
		if (loRaModulationInfo != null) {
			loRaModulationInfo.setTxInfo(cSRawBodySave.getTxInfo());
			loRaModulationInfoRepository.save(loRaModulationInfo);
		}

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(cSRawBodySave, httpServletRequest,
				httpServletResponse, cSRawBodySave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(cSRawBodySave);
	}

	@GetMapping
	public List<CSRawBody> read() {
		return cSRawBodyRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CSRawBody> readByID(@PathVariable Long id) {
		Optional<CSRawBody> cSRawBodySave = this.cSRawBodyRepository.findById(id);
		return cSRawBodySave.isPresent() ? ResponseEntity.ok(cSRawBodySave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CSRawBody> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) CSRawBody cSRawBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		CSRawBody cSRawBodySave = cSRawBodyService.update(cSRawBody, id);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(cSRawBodySave, httpServletRequest,
				httpServletResponse, cSRawBodySave.getId()));

		return ResponseEntity.ok(cSRawBodySave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cSRawBodyRepository.deleteById(id);
	}

}
