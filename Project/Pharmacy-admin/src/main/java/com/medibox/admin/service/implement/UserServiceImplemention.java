package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.User;
import com.medibox.admin.reprository.UserRepository;
import com.medibox.admin.service.UserService;

@Service
public class UserServiceImplemention implements UserService  {
    @Autowired
	private  UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		if(  user!=null) {
			return userRepository.save(user);
		}
		return null;
	}

	
	
	@Override
	public List<User> listOfUser() {
		return userRepository.findAll();
	}

	
	@Override
	public User findByUserId(Integer UserId) {
		if(  UserId!=null) {
			return userRepository.findBySellerId(UserId);
		}
		return null;
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}

	@Override
	public void editUser(User user) {
		if(  user!=null) {
			userRepository.save(user);
		}
		
	}

	@Override
	public int countUser() {
		
		return userRepository.sellerCount();
	}



	@Override
	public User findByUserEmailAndPassword(String email, String pass) {
		// TODO Auto-generated method stub
		return userRepository.findByUserEmailAndPassword(email,pass);
	}



	@Override
	public User findByUserEmail(String email) {
		
		return userRepository.findByUserEmail(email);
	}



	@Override
	public User findByUserMobile(String mobile) {
		// TODO Auto-generated method stub
		return userRepository.findByUserMobile(mobile);
	}

}
