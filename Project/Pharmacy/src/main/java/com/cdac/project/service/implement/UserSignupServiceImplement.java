package com.cdac.project.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.project.model.UserSignup;
import com.cdac.project.repository.UserSignupRepository;
import com.cdac.project.service.UserSignupService;

@Service
public class UserSignupServiceImplement implements UserSignupService {

	@Autowired
	UserSignupRepository userSignupRepository;

	@Override
	public UserSignup saveUser(UserSignup user) {
		// TODO Auto-generated method stub
		return userSignupRepository.save(user);
	}

}
