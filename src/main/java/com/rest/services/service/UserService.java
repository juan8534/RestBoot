package com.rest.services.service;

import java.util.List;

import com.rest.services.modelo.User;

public interface UserService {

	/**
	 * Guarda un usuario
	 * 
	 * @param user
	 * @return el usuario guardado
	 */
	User save(User user);

	/**
	 * Recuperra la lista de usuarios
	 * 
	 * @return lista de usuarios
	 */
	List<User> findAll();

	/**
	 * Elimina un usuario con el id recibido
	 * 
	 * @param id
	 */
	void deleteUser(Long id);

}
