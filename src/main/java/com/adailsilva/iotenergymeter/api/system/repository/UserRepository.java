package com.adailsilva.iotenergymeter.api.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
