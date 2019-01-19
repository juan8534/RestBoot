package com.rest.services.modelo;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
@Access(AccessType.FIELD)
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name_costumer", nullable = false, length = 255)
	private String nameCostumer;
	
	@Column(name = "surname_costumer", nullable = false, length = 255)
	private String surnameCostumer;
	
	@Column(name = "phone_costumer", nullable = false, length = 255)
	private String phoneCostmer;
	
	@Column(name = "reservation_date", nullable = false, length = 255)
	private Date reservationDate;

	@Column(name = "number_people", nullable = false, length = 255)
	private int numberPeoPle;
	
	@Column(name = "id_restaurant", nullable = false, length = 255)
	private int idRestaurant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCostumer() {
		return nameCostumer;
	}

	public void setNameCostumer(String nameCostumer) {
		this.nameCostumer = nameCostumer;
	}

	public String getSurnameCostumer() {
		return surnameCostumer;
	}

	public void setSurnameCostumer(String surnameCostumer) {
		this.surnameCostumer = surnameCostumer;
	}

	public String getPhoneCostmer() {
		return phoneCostmer;
	}

	public void setPhoneCostmer(String phoneCostmer) {
		this.phoneCostmer = phoneCostmer;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getNumberPeoPle() {
		return numberPeoPle;
	}

	public void setNumberPeoPle(int numberPeoPle) {
		this.numberPeoPle = numberPeoPle;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

}
