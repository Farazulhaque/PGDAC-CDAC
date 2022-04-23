package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.OrderStatus;

public interface OrderStatusService {
	
	
	
	OrderStatus addOrderStatus(OrderStatus OrderStatus);

	List<OrderStatus> listOfOrderStatus();
	
	OrderStatus findByOrderStatusId(Integer OrderStatusId);
	
	void deleteOrderStatus(OrderStatus OrderStatus);

	void editOrderStatus(OrderStatus OrderStatus);
	
	//OrderStatus findByOrderStatusEmail(String email);
	
	
	
	List<OrderStatus> pendingListOfOrderStatus();
	
	List<OrderStatus> confirmedListOfOrderStatus();
	
	List<OrderStatus> deliveredListOfOrderStatus();
	
	List<OrderStatus> shipedListOfOrderStatus();
	
	

	List<OrderStatus> canceledListOfOrderStatus();

}
