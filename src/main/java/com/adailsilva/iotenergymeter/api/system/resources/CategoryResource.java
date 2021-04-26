package com.adailsilva.iotenergymeter.api.system.resources;

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
import com.adailsilva.iotenergymeter.api.system.model.Category;
import com.adailsilva.iotenergymeter.api.system.repository.CategoryRepository;
import com.adailsilva.iotenergymeter.api.system.service.CategoryService;
@RestController
@RequestMapping("/system/categories")
public class CategoryResource {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Category> create(@Valid @RequestBody(required = true) Category category,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Category categorySave = categoryRepository.save(category);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(categorySave, httpServletRequest, httpServletResponse, categorySave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(categorySave);
	}

	@GetMapping
	public List<Category> read() {
		return categoryRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> readByID(@PathVariable Long id) {
		Optional<Category> categorySave = categoryRepository.findById(id);
		return categorySave.isPresent() ? ResponseEntity.ok(categorySave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) Category category, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		Category categorySave = categoryService.update(category, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(categorySave, httpServletRequest, httpServletResponse, categorySave.getId()));

		return ResponseEntity.ok(categorySave);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		categoryRepository.deleteById(id);
	}

}
