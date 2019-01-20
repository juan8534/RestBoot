package com.rest.services.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.services.modelo.Reservation;
import com.rest.services.service.ReservationService;
import com.rest.services.util.RestResponse;

@RestController
public class ReservationController {

	@Autowired
	protected ReservationService reservationService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value = "/saveOrUpdateReservation", method = RequestMethod.POST)
	public RestResponse saveOrUpdateReservation(@RequestBody String reservationJson)
			throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper = new ObjectMapper();
		Reservation reservation = this.mapper.readValue(reservationJson, Reservation.class);
		
		boolean reservationValid = validateRestaurant(reservation);
		
		if (!reservationValid) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados!!");
		}
		this.reservationService.save(reservation);

		return new RestResponse(HttpStatus.OK.value(), "Reservación registrada!");
	}
	
	private boolean validateRestaurant(Reservation reservation) {
		boolean isValid = true;

		if (StringUtils.trimToNull(reservation.getNameCostumer()) == null) {
			isValid = false;
		}
		
		if (StringUtils.trimToNull(reservation.getSurnameCostumer()) == null) {
			isValid = false;
		}
		
		if (StringUtils.trimToNull(reservation.getPhoneCostmer()) == null) {
			isValid = false;
		}
		
		if (reservation.getNumberPeoPle() < 0) {
			isValid = false;
		}
		
		if (reservation.getIdRestaurant() < 0) {
			isValid = false;
		}
		
		return isValid;
	}
	
	
	@RequestMapping(value = "/getReservation", method = RequestMethod.GET)
	public List<Reservation> getReservation() {
		List<Reservation> listaReservas = this.reservationService.findAll();
		return listaReservas;
	}
	
	
	
	@RequestMapping(value = "/getReservationByID/{id}", method = RequestMethod.GET)
	public Reservation getReservationById(@PathVariable Long id) {
		Reservation reservaById;
		reservaById = this.reservationService.findById(id);
		return reservaById;
	}

	@RequestMapping(value = "/deleteReservation", method = RequestMethod.POST)
	public void deletReservation(@RequestBody String reservationJson) throws Exception {
		
		this.mapper = new ObjectMapper();
		Reservation reservation = this.mapper.readValue(reservationJson, Reservation.class);

		if (reservation.getId() == null) {
			throw new Exception("El id de la reserva no puede ser nula");
		}
		this.reservationService.deleteReservation(reservation.getId());

	}
}