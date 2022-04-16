package com.medibox.admin.service;

import java.util.List;

import com.medibox.admin.model.OrderMaster;

public interface OrderMasterService {

	OrderMaster addOrderMaster(OrderMaster orderMaster);

	List<OrderMaster> listOfOrderMaster();

	OrderMaster findByOrderMasterId(Integer OrderMasterId);

	void deleteOrderMaster(OrderMaster OrderMaster);

	void editOrderMaster(OrderMaster OrderMaster);

	// OrderMaster findByOrderMasterEmail(String email);

	int countOrderMaster();

	List<OrderMaster> pendingListOfOrderMaster();

}
