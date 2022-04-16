package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.OrderDetails;
import com.medibox.admin.reprository.OrderDetailsRepository;
import com.medibox.admin.reprository.OrderStatusRepository;
import com.medibox.admin.service.OrderDetailsService;

@Service
public class OrderDetailsImplementation implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public OrderDetails addOrderDetails(OrderDetails orderDetails) {

		return orderDetailsRepository.save(orderDetails);
	}

	@Override
	public List<OrderDetails> listOfOrderDetails() {
		// TODO Auto-generated method stub
		return orderDetailsRepository.findAll();
	}

	@Override
	public OrderDetails findByOrderDetailsId(Integer OrderDetailsId) {

		return orderDetailsRepository.findOrderDetailsById(OrderDetailsId);
	}

	@Override
	public void deleteOrderDetails(OrderDetails OrderDetails) {
		orderDetailsRepository.delete(OrderDetails);

	}

	@Override
	public void editOrderDetails(OrderDetails orderDetails) {
		orderDetailsRepository.save(orderDetails);

	}

	@Override
	public List<OrderDetails> pendingListOfOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
