package com.boot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Users;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(Users user) {
		if (user != null) {
			userRepository.save(user);
		}

	}

	@Override
	public Users findByEmailAndPassword(String email, String password) {
		Users user = null;
		if (email != null && password != null) {
			user = userRepository.findByEmailAndPassword(email, password);
		}
		return user;
	}

	@Override
	public Users findByEmail(String email) {
		if (email != null) {
			return userRepository.findByEmail(email);
		}
		return null;
	}

}
