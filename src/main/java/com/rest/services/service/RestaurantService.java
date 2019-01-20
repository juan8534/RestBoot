package com.rest.services.service;

import java.util.List;

import com.rest.services.modelo.Restaurant;

public interface RestaurantService {
	
	/**
	 * Guarda un resgistro en la tabla restaurante
	 * 
	 * @param user
	 * @return el restaurante guardado
	 */
	Restaurant save(Restaurant restaurant);

	/**
	 * Recuperra la lista de restaurantes
	 * 
	 * @return lista de restaurantes
	 */
	List<Restaurant> findAll();
	
	/**
	 * Elimina un restaurante con el id recibido
	 * 
	 * @param id
	 */
	void deleteRestaurant(Long id);
	
	/**
	 * Obtenemos el restaurante por id
	 * 
	 * @param id
	 */
	Restaurant findById(Long id);
}
