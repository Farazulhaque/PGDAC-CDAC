package com.medibox.admin.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibox.admin.model.OrderMaster;
import com.medibox.admin.reprository.OrderMasterRepository;
import com.medibox.admin.service.OrderMasterService;
@Service
public class OrderMasterServiceImplementation implements OrderMasterService {
	
	@Autowired
	private OrderMasterRepository oMasterRepository;

	@Override
	public OrderMaster addOrderMaster(OrderMaster orderMaster) {
		
		return oMasterRepository.save(orderMaster);
	}

	@Override
	public List<OrderMaster> listOfOrderMaster() {
		
		//return oMasterRepository.findAll();
		return oMasterRepository.LIST();
	}

	@Override
	public OrderMaster findByOrderMasterId(Integer OrderMasterId) {
		// TODO Auto-generated method stub
		return oMasterRepository.findOrderMasterById(OrderMasterId);
	}

	@Override
	public void deleteOrderMaster(OrderMaster OrderMaster) {
		oMasterRepository.delete(OrderMaster);
		
	}

	@Override
	public void editOrderMaster(OrderMaster OrderMaster) {
		oMasterRepository.save(OrderMaster);
		
	}

	@Override
	public int countOrderMaster() {
		
		return (int) oMasterRepository.count();
	}

	@Override
	public List<OrderMaster> pendingListOfOrderMaster() {
		
		return oMasterRepository.pendingListOfOrderMaster();
	}

	@Override
	public int PendingOrderCount() {
		
		return oMasterRepository.PendingOrderCount();
	}

	@Override
	public List<OrderMaster> findOrderBySellerId(Integer sellerId) {
		return oMasterRepository.findOrderBysellerId(sellerId);
	}

	@Override
	public List<OrderMaster> findOrderByUserId(Integer userId) {
		return oMasterRepository.findOrderByUserId(userId);
	}

	@Override
	public List<OrderMaster> findOrderBySellerPendingOrder(Integer sellerId) {
		// TODO Auto-generated method stub
		return oMasterRepository.findOrderBySellerPendingOrder(sellerId);
	}

	@Override
	public int PendingOrderOfSellerCount(Integer sellerId) {
		// TODO Auto-generated method stub
		return oMasterRepository.PendingOrdersellerCount(sellerId);
	}

}
