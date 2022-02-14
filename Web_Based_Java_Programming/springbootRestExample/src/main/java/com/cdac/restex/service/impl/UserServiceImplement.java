package com.cdac.restex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.restex.model.User;
import com.cdac.restex.repository.UserRepository;
import com.cdac.restex.service.UserService;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
