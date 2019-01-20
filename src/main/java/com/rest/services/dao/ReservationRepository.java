package com.rest.services.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rest.services.modelo.Reservation;



public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@SuppressWarnings("unchecked")
	@Override
	Reservation save(Reservation reservation);
	
	
	@Override
	Optional<Reservation> findById(Long id);
	
//	 @Query(nativeQuery = true, value = "select rs.id,rs.name_costumer,rs.surname_costumer,rs.phone_costumer,rs.reservation_date,rs.number_people,rs.id_restaurant, rt.name_restaurant,rt.id from reservation as rs, restaurant as rt where id_restaurant = rt.id")
//	 List<Reservation> findAllWithRestaurant();
}
