package com.medibox.admin.service.implement;

import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.UserAddress;
import com.medibox.admin.reprository.UserAddressReprository;
import com.medibox.admin.service.UserAddressService;

@Service
public class UserAddressServiceImplemention implements UserAddressService{

	@Autowired
	private UserAddressReprository uAddReprository;
	
	
	@Override
	public UserAddress addUserAddress(UserAddress user) {
		
			return uAddReprository.save(user);
		
	}

	@Override
	public List<UserAddress> listOfUser() {
		
		return uAddReprository.findAll();
	}

	@Override
	public UserAddress findByUserAddressId(Integer UserAddressId) {
		if(  UserAddressId!=null) {
			return uAddReprository.UserAddressId(UserAddressId);
		}
		return null;
	}

	@Override
	public void deleteUserAddress(UserAddress userADD) {
		uAddReprository.delete( userADD);
		System.out.println(" implem Delete");
	}

	@Override
	public void editUserAddress(UserAddress user) {
		if(user!=null) {
			 uAddReprository.save(user);
		}
	}

}
