package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.Seller;
import com.medibox.admin.reprository.SellerReprository;
import com.medibox.admin.service.SellerService;
@Service
public class SellerServiceImplemention implements SellerService {

	@Autowired
	private SellerReprository sellerReprository;
	
	@Override
	public Seller addSeller(Seller seller) {
		sellerReprository.save(seller);
		return null;
	}

	@Override
	public List<Seller> listOfSeller() {
		
		return sellerReprository.findAll();
	}

	@Override
	public Seller findBySellerId(Integer SellerId) {
		
		return sellerReprository.findBySellerId(SellerId);
	}

	@Override
	public void deleteSeller(Seller seller) {
		
		sellerReprository.delete(seller);
	}

	@Override
	public void editSeller(Seller seller) {
		
		sellerReprository.save(seller);
	}

	@Override
	public int countSeller() {
		return sellerReprository.sellerCount();
	}

	@Override
	public List<Seller> pendingListOfSeller() {
		
		return sellerReprository.findPendingList(0);
	}

	@Override
	public Seller findBySellerEmailAndPasswordStatusIsActive(String email, String pass) {
		// TODO Auto-generated method stub
		return sellerReprository.findBySellerEmailAndPasswordStatusIsActive(email, pass);
	}

	@Override
	public Seller findBySellerEmail(String email) {
		
		return sellerReprository.findBySellerEmail(email);
	}

	@Override
	public Seller findSellerByPincode(Integer pincode) {
		// TODO Auto-generated method stub
		return sellerReprository.findSellerByPincode(pincode);
	}

}
