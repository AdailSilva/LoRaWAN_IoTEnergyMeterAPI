package com.adailsilva.iotenergymeter.api.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adailsilva.iotenergymeter.api.system.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
