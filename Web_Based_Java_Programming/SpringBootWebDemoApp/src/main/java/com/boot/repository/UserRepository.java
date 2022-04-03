package com.boot.repository;

import com.boot.entity.Users;

/**
 * Repository for user object
 * 
 * @author admin
 *
 */
public interface UserRepository {

	/**
	 * Saves user in database
	 * 
	 * @param user
	 */
	void save(Users user);

	/**
	 * Get user from database by login and password
	 * 
	 * @param email
	 * @param password
	 * @return found user
	 */
	Users findByEmailAndPassword(String email, String password);

	/**
	 * Finds user by login
	 * 
	 * @param email
	 * @return user object
	 */
	Users findByEmail(String email);
}
