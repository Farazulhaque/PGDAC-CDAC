package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.Seller;
import com.medibox.admin.model.User;

public interface SellerService {

	Seller addSeller(Seller user);

	List<Seller> listOfSeller();

	Seller findBySellerId(Integer SellerId);

	void deleteSeller(Seller seller);

	void editSeller(Seller seller);

	Seller findBySellerEmailAndPasswordStatusIsActive(String email, String pass);

	Seller findBySellerEmail(String email);

	int countSeller();

	List<Seller> pendingListOfSeller();

	Seller findSellerByPincode(Integer pincode);

}
