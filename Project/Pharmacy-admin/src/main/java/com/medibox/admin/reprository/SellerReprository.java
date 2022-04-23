package com.medibox.admin.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.Seller;

public interface SellerReprository extends JpaRepository<Seller, Integer> {

	@Query("select s from Seller s where s.sellerId=?1")
	Seller findBySellerId(Integer sellerId);

	@Query("select count(s) from Seller s ")
	int sellerCount();

	@Query("select s from Seller s where s.status=?1")
	List<Seller> findPendingList(Integer a);

//	@Query("select s from Seller s where s.emailId=?1 and s.password=?2  and s.status=1")
//	Seller findBySellerEmailAndPasswordStatusIsActive(String email, String pass);

	@Query("select s from Seller s where s.emailId=?1 and s.password=?2")
	Seller findBySellerEmailAndPasswordStatusIsActive(String email, String pass);

	@Query("select s from Seller s where s.emailId=?1")
	Seller findBySellerEmail(String email);

	@Query("select s from Seller s where s.shopPincode=?1")
	Seller findSellerByPincode(Integer pincode);

}
