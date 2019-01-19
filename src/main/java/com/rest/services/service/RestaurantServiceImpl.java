package com.rest.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.services.dao.RestaurantRepository;
import com.rest.services.modelo.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	protected RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant save(Restaurant restaurant) {
		return this.restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> findAll() {
		return this.restaurantRepository.findAll();
	}

	@Override
	public void deleteRestaurant(Long id) {
		this.restaurantRepository.deleteById(id);
	}

}
