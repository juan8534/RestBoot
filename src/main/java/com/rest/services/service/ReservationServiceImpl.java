package com.rest.services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.rest.services.dao.ReservationRepository;
import com.rest.services.modelo.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	protected ReservationRepository reservationService;

	@Override
	public Reservation save(Reservation reservation) {	
		return this.reservationService.save(reservation);
	}

	@Override
	public List<Reservation> findAll() {
		return this.reservationService.findAll();
	}
	

	@Override
	public void deleteReservation(Long id) {
		this.reservationService.deleteById(id);
		
	}

	@Override
	public Reservation findById(Long id) {
		return this.reservationService.findById(id).get();
	}
	
}
