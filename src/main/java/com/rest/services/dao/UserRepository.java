package com.rest.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.services.modelo.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@SuppressWarnings("unchecked")
	@Override
	User save(User user);

}
