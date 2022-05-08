package com.adailsilva.iotenergymeter.api.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
