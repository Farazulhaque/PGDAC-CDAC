package com.medibox.admin.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.UserAddress;

public interface UserAddressReprository extends JpaRepository<UserAddress, Integer>{

	
	@Query("select u from UserAddress u where u.userAddressId=?1")
	UserAddress UserAddressId(Integer userAddressId);

	
	
	
	
	
	
	
	
	
	
	
}
