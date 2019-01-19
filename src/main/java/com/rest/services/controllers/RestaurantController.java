package com.rest.services.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.services.modelo.Restaurant;
import com.rest.services.service.RestaurantService;
import com.rest.services.util.RestResponse;

@RestController
public class RestaurantController {

	@Autowired
	protected RestaurantService restaurantService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value = "/saveOrUpdateRestaurant", method = RequestMethod.POST)
	public RestResponse saveOrUpdateRestaurant(@RequestBody String restaurantJson)
			throws JsonParseException, JsonMappingException, IOException {
		this.mapper = new ObjectMapper();
		Restaurant restaurant = this.mapper.readValue(restaurantJson, Restaurant.class);
		
		boolean restaurantValid = validateRestaurant(restaurant);
		
		if (!restaurantValid) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados!!");
		}
		this.restaurantService.save(restaurant);

		return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
	}
	
	private boolean validateRestaurant(Restaurant restaurant) {
		boolean isValid = true;

		if (StringUtils.trimToNull(restaurant.getNameRestaurant()) == null) {
			isValid = false;
		}
		
		if (StringUtils.trimToNull(restaurant.getAdressRestaurant()) == null) {
			isValid = false;
		}
		
		if (StringUtils.trimToNull(restaurant.getPhoneRestaurant()) == null) {
			isValid = false;
		}

		
		return isValid;
	}
	
	@RequestMapping(value = "/getRestaurants", method = RequestMethod.GET)
	public List<Restaurant> getRestaurant() {
		return this.restaurantService.findAll();
	}

	@RequestMapping(value = "/deleteRestaurant", method = RequestMethod.POST)
	public void deleteRestaurant(@RequestBody String restaurantJson) throws Exception {
		this.mapper = new ObjectMapper();
		Restaurant restaurant = this.mapper.readValue(restaurantJson, Restaurant.class);

		if (restaurant.getId() == null) {
			throw new Exception("El id del usuario no puede ser nulo");
		}
		this.restaurantService.deleteRestaurant(restaurant.getId());

	}

}
