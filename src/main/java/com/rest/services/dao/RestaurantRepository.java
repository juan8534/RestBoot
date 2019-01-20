package com.rest.services.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rest.services.modelo.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@SuppressWarnings("unchecked")
	@Override
	Restaurant save(Restaurant restaurant);
	
	@Override
	Optional<Restaurant> findById(Long id);
}
