package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.OrderMaster;

public interface OrderMasterService {

	
	
	OrderMaster addOrderMaster(OrderMaster orderMaster);

	List<OrderMaster> listOfOrderMaster();
	
	OrderMaster findByOrderMasterId(Integer OrderMasterId);
	
	
	List<OrderMaster> findOrderBySellerId(Integer sellerId);
	
	List<OrderMaster> findOrderByUserId(Integer sellerId);
	
	
	void deleteOrderMaster(OrderMaster OrderMaster);

	void editOrderMaster(OrderMaster OrderMaster);
	
	//OrderMaster findByOrderMasterEmail(String email);
	
	int countOrderMaster();
	
	List<OrderMaster> pendingListOfOrderMaster();
	
	List<OrderMaster> findOrderBySellerPendingOrder(Integer sellerId);
	
	int  PendingOrderOfSellerCount(Integer sellerId);
	
	int  PendingOrderCount();
	
	
	
}
