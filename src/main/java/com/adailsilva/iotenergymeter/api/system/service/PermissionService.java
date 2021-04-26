package com.adailsilva.iotenergymeter.api.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.system.model.Permission;
import com.adailsilva.iotenergymeter.api.system.repository.PermissionRepository;

@Service
public class PermissionService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private PermissionRepository permissionRepository;

	private Permission getPermissionByID(Long id) {

		Permission permissionSave = permissionRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return permissionSave;
	}

	public Permission update(Permission permission, Long id) {

		Permission permissionSave = getPermissionByID(id);
//		BeanUtils.copyProperties(permission, permissionSave, "id");
		permissionSave.setId(id);
		permissionSave.setDescription(permission.getDescription());
		permissionSave.setActive(permission.getActive());
		permissionSave.setUsers(permissionSave.getUsers());

		return permissionRepository.save(permissionSave);
	}
	
	public void partialUpdateActive(Long id, Boolean active) {

		Permission permissionSave = getPermissionByID(id);
		permissionSave.setActive(active);
		permissionRepository.save(permissionSave);

	}

}
