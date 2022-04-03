package com.boot.service;

import com.boot.entity.Users;

/**
 * Service which works with {@UserRepository}
 * @author admin
 *
 */
public interface UserService {

	void save(Users user);

	Users findByEmailAndPassword(String email, String password);

	Users findByEmail(String email);
}
