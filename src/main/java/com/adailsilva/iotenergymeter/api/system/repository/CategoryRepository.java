package com.adailsilva.iotenergymeter.api.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
