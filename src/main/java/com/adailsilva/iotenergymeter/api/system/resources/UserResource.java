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
import com.adailsilva.iotenergymeter.api.system.model.User;
import com.adailsilva.iotenergymeter.api.system.repository.UserRepository;
import com.adailsilva.iotenergymeter.api.system.service.UserService;

@RestController
@RequestMapping("/system/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody(required = true) User user,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		User userSave = userRepository.save(user);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(userSave, httpServletRequest, httpServletResponse, userSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
	}

	@GetMapping
	public List<User> read() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> readByID(@PathVariable Long id) {
		Optional<User> userSave = userRepository.findById(id);
		return userSave.isPresent() ? ResponseEntity.ok(userSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody(required = true) User user,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		User userSave = userService.update(user, id);

		applicationEventPublisher.publishEvent(
				new ResourceCreatedEvent(userSave, httpServletRequest, httpServletResponse, userSave.getId()));

		return ResponseEntity.ok(userSave);
	}

	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void partialUpdateActive(@PathVariable Long id, @RequestBody(required = true) Boolean active) {

		userService.partialUpdateActive(id, active);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}

}
