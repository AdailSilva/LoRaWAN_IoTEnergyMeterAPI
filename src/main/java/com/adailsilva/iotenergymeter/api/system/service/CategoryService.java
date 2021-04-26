package com.adailsilva.iotenergymeter.api.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adailsilva.iotenergymeter.api.system.model.Category;
import com.adailsilva.iotenergymeter.api.system.repository.CategoryRepository;

@Service
public class CategoryService {

	// create

	// read

	// readByID

	// update

	// updateByID

	// delete

	@Autowired
	private CategoryRepository categoryRepository;

	private Category getCategoryByID(Long id) {

		Category categorySave = categoryRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return categorySave;

	}

	public Category update(Category category, Long id) {

		Category categorySave = getCategoryByID(id);

//		BeanUtils.copyProperties(category, categorySave, "id");
		categorySave.setId(id);
		categorySave.setName(category.getName());

		return categoryRepository.save(categorySave);
	}

}
