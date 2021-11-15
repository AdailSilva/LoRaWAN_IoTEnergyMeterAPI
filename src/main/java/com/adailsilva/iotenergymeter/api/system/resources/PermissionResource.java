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

import com.adailsilva.iotenergymeter.api.events.ResourceCreatedEvent;
import com.adailsilva.iotenergymeter.api.system.entities.Permission;
import com.adailsilva.iotenergymeter.api.system.repositories.PermissionRepository;
import com.adailsilva.iotenergymeter.api.system.services.PermissionService;

@RestController
@RequestMapping("/system/permissions")
public class PermissionResource {

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private PermissionService permissionService;

	@PostMapping
	public ResponseEntity<Permission> create(@Valid @RequestBody(required = true) Permission permission,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Permission permissionSave = permissionRepository.save(permission);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(permissionSave, httpServletRequest,
				httpServletResponse, permissionSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(permissionSave);
	}

	@GetMapping
	public List<Permission> read() {
		return permissionRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Permission> readByID(@PathVariable Long id) {
		Optional<Permission> permissionSave = permissionRepository.findById(id);
		return permissionSave.isPresent() ? ResponseEntity.ok(permissionSave.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Permission> update(@PathVariable Long id,
			@Valid @RequestBody(required = true) Permission permission, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		Permission permissionSave = permissionService.update(permission, id);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(permissionSave, httpServletRequest,
				httpServletResponse, permissionSave.getId()));

		return ResponseEntity.ok(permissionSave);
	}
	
	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void partialUpdateActive(@PathVariable Long id, @RequestBody(required = true) Boolean active) {

		permissionService.partialUpdateActive(id, active);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		permissionRepository.deleteById(id);
	}

}
