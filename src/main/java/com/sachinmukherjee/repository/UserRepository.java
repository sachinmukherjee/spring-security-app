package com.sachinmukherjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachinmukherjee.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
