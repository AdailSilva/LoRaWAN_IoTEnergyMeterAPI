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

import com.adailsilva.iotenergymeter.api.chirpstack.entities.ImmediatelyTimingInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.LoRaModulationInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.entities.TxInfo;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.ImmediatelyTimingInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.LoRaModulationInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.repositories.TxInfoRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.services.TxInfoService;
import com.adailsilva.iotenergymeter.api.events.ResourceCreatedEvent;

@RestController
@RequestMapping("/chirpstack/txinfo")
public class TxInfoResource {

	@Autowired
	private TxInfoRepository txInfoRepository;

	@Autowired
	private ImmediatelyTimingInfoRepository immediatelyTimingInfoRepository;

	@Autowired
	private LoRaModulationInfoRepository loRaModulationInfoRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private TxInfoService txInfoService;

	@PostMapping
	public ResponseEntity<TxInfo> create(@Valid @RequestBody(required = true) TxInfo txInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		TxInfo txInfoSave = txInfoRepository.save(txInfo);

		// UPDATES: Foreign keys
		ImmediatelyTimingInfo immediatelyTimingInfo = txInfoSave.getImmediatelyTimingInfo();
		if (immediatelyTimingInfo != null) {
			immediatelyTimingInfo.setTxInfo(txInfoSave);
			immediatelyTimingInfoRepository.save(immediatelyTimingInfo);
		}
		
		LoRaModulationInfo loRaModulationInfo = txInfoSave.getLoRaModulationInfo();
		if (loRaModulationInfo != null) {
			loRaModulationInfo.setTxInfo(txInfoSave);
			loRaModulationInfoRepository.save(loRaModulationInfo);
		}

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(txInfoSave, httpServletRequest, httpServletResponse, txInfoSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(txInfoSave);
	}

	@GetMapping
	public List<TxInfo> read() {
		return txInfoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TxInfo> readByID(@PathVariable Long id) {
		Optional<TxInfo> txInfoSave = this.txInfoRepository.findById(id);
		return txInfoSave.isPresent() ? ResponseEntity.ok(txInfoSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<TxInfo> update(@PathVariable Long id, @Valid @RequestBody(required = true) TxInfo txInfo,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		TxInfo txInfoSave = txInfoService.update(txInfo, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(txInfoSave, httpServletRequest, httpServletResponse, txInfoSave.getId()));

		return ResponseEntity.ok(txInfoSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		txInfoRepository.deleteById(id);
	}

}
