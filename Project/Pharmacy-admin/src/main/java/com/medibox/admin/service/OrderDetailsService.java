package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.OrderDetails;


public interface OrderDetailsService {

	
	OrderDetails addOrderDetails(OrderDetails user);

	List<OrderDetails> listOfOrderDetails();
	
	OrderDetails findByOrderDetailsId(Integer OrderDetailsId);
	
	void deleteOrderDetails(OrderDetails OrderDetails);

	void editOrderDetails(OrderDetails OrderDetails);
	
	//OrderDetails findByOrderDetailsEmail(String email);
	
	
	
	List<OrderDetails> pendingListOfOrderDetails();
	
}
