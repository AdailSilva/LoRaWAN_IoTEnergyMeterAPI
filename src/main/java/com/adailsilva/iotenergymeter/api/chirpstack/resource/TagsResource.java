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

import com.adailsilva.iotenergymeter.api.chirpstack.model.Tags;
import com.adailsilva.iotenergymeter.api.chirpstack.repository.TagsRepository;
import com.adailsilva.iotenergymeter.api.chirpstack.service.TagsService;
import com.adailsilva.iotenergymeter.api.event.ResourceCreatedEvent;

@RestController
@RequestMapping("/chirpstack/tags")
public class TagsResource {

	@Autowired
	private TagsRepository tagsRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private TagsService tagsService;

	@PostMapping
	public ResponseEntity<Tags> create(@Valid @RequestBody(required = true) Tags tags,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Tags tagsSave = tagsRepository.save(tags);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(tagsSave, httpServletRequest, httpServletResponse, tagsSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(tagsSave);
	}

	@GetMapping
	public List<Tags> read() {
		return tagsRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tags> readByID(@PathVariable Long id) {
		Optional<Tags> tagsSave = tagsRepository.findById(id);
		return tagsSave.isPresent() ? ResponseEntity.ok(tagsSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tags> update(@PathVariable Long id, @Valid @RequestBody(required = true) Tags tags,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		Tags tagsSave = tagsService.update(tags, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(tagsSave, httpServletRequest, httpServletResponse, tagsSave.getId()));

		return ResponseEntity.ok(tagsSave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tagsRepository.deleteById(id);
	}

}
