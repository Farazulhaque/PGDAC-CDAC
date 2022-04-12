package com.medibox.admin.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	@Query("select u from User u where u.userId=?1")
	User findBySellerId(Integer sellerId);

	@Query("select count(u) from User u ")
	int sellerCount();

	@Query("select u from User u where u.emailId=?1  and u.password=?2")
	User findByUserEmailAndPassword(String email, String pass);

	@Query("select u from User u where u.emailId=?1")
	User findByUserEmail(String email);

	@Query("select u from User u where u.contactNumber=?1")
	User findByUserMobile(String mobile);
}
