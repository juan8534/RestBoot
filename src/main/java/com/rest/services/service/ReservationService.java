package com.rest.services.service;

import java.util.List;
import java.util.Optional;

import com.rest.services.modelo.Reservation;

public interface ReservationService {
	
	/**
	 * Guarda un resgistro en la tabla reservation
	 * 
	 * @param reservation
	 * @return la reserva guardada
	 */
	Reservation save(Reservation reservation);
	
	/**
	 * Recuperra la lista de reservas guardadas
	 * 
	 * @return lista de reservas
	 */
	List<Reservation> findAll();

	/**
	 * Elimina un registro en la tabal reservas con el id
	 * 
	 * @param id
	 */
	void deleteReservation(Long id);
	
	/**
	 * 
	 * Obtenemos la reservacion por id
	 * 
	 * @param id
	 * 
	 * **/
	Reservation findById(Long id);
	
}
