package com.medibox.admin.service;

import java.util.List;
import com.medibox.admin.model.User;

public interface UserService {

	
	User addUser(User user);

	List<User> listOfUser();
	
	User findByUserId(Integer UserId);
	
	void deleteUser(User user);

	void editUser(User user);
	
	
	User findByUserEmailAndPassword(String email,String pass);
	
	User findByUserEmail(String email);
	
	User findByUserMobile(String email);
	
	int countUser();
}
