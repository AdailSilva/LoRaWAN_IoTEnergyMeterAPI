package com.adailsilva.iotenergymeter.api.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.system.model.User;
import com.adailsilva.iotenergymeter.api.system.repository.UserRepository;

@Service
public class UserService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private UserRepository userRepository;

	private User getUserByID(Long id) {

		User userSave = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

		return userSave;
	}

	public User update(User user, Long id) {

		User userSave = getUserByID(id);

//		BeanUtils.copyProperties(user, userSave, "id");
		userSave.setId(id);
		userSave.setName(user.getName());
		userSave.setEmail(user.getEmail());
		userSave.setPassword(user.getPassword());
		userSave.setActive(user.getActive());
		userSave.setPermissions(userSave.getPermissions());

		return userRepository.save(userSave);
	}

	public void partialUpdateActive(Long id, Boolean active) {

		User userSave = getUserByID(id);
		userSave.setActive(active);
		userRepository.save(userSave);

	}

}
