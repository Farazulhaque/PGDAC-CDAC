package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.UserAddress;

public interface UserAddressService {

	
	UserAddress addUserAddress(UserAddress user);

	List<UserAddress> listOfUser();
	
	UserAddress findByUserAddressId(Integer UserAddressId);
	
	void deleteUserAddress(UserAddress user);

	void editUserAddress(UserAddress user);
	
}
