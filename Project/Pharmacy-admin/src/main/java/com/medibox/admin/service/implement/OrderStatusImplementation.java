package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.OrderStatus;
import com.medibox.admin.reprository.OrderStatusRepository;
import com.medibox.admin.service.OrderStatusService;
@Service
public class OrderStatusImplementation implements OrderStatusService {

	
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Override
	public OrderStatus addOrderStatus(OrderStatus OrderStatus) {
		
		return orderStatusRepository.save(OrderStatus);
	}

	@Override
	public List<OrderStatus> listOfOrderStatus() {
		
		return orderStatusRepository.findAll();
	}

	@Override
	public OrderStatus findByOrderStatusId(Integer OrderStatusId) {
		
		return orderStatusRepository.findOrderStatusById(OrderStatusId);
	}

	@Override
	public void deleteOrderStatus(OrderStatus OrderStatus) {
		
		orderStatusRepository.delete(OrderStatus);
		
	}

	@Override
	public void editOrderStatus(OrderStatus OrderStatus) {
		orderStatusRepository.save(OrderStatus);
		
	}


	@Override
	public List<OrderStatus> pendingListOfOrderStatus() {
		return  orderStatusRepository.findpendingOrderStatus();
	}

	@Override
	public List<OrderStatus> confirmedListOfOrderStatus() {
		
		return orderStatusRepository.findcompleteOrderStatus();
	}

	@Override
	public List<OrderStatus> deliveredListOfOrderStatus() {
		
		return orderStatusRepository.findDeliveredOrderStatus();
	}

	@Override
	public List<OrderStatus> shipedListOfOrderStatus() {
		// TODO Auto-generated method stub
		return orderStatusRepository.findShipedOrderStatus();
	}

	@Override
	public List<OrderStatus> canceledListOfOrderStatus() {
		// TODO Auto-generated method stub
		return orderStatusRepository.canceledOrder();
	}

}
