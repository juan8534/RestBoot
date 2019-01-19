package com.rest.services.modelo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
@Access(AccessType.FIELD)
public class Restaurant {

	// private static final long serialVersionUID = -9126521037631481721L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name_restaurant", nullable = false, length = 255)
	private String nameRestaurant;

	@Column(name = "adress_restaurant", nullable = true, length = 255)
	private String adressRestaurant;

	@Column(name = "phone_restaurant", nullable = false, length = 255)
	private String phoneRestaurant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameRestaurant() {
		return nameRestaurant;
	}

	public void setNameRestaurant(String nameRestaurant) {
		this.nameRestaurant = nameRestaurant;
	}

	public String getAdressRestaurant() {
		return adressRestaurant;
	}

	public void setAdressRestaurant(String adressRestaurant) {
		this.adressRestaurant = adressRestaurant;
	}

	public String getPhoneRestaurant() {
		return phoneRestaurant;
	}

	public void setPhoneRestaurant(String phoneRestaurant) {
		this.phoneRestaurant = phoneRestaurant;
	}

	
}
