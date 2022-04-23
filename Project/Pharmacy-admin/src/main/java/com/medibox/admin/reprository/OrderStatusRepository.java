package com.medibox.admin.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

	
	@Query("select u from OrderStatus u where u.statusId=?1")
	OrderStatus findOrderStatusById(Integer statusId );
	
	
	
	@Query("select u from OrderStatus u where u.statusType=0")
	List<OrderStatus> findcompleteOrderStatus();
	
	
	
	@Query("select u from OrderStatus u where u.statusType=1")
	List<OrderStatus> findpendingOrderStatus();
	
	
	@Query("select u from OrderStatus u where u.statusType=2")
	List<OrderStatus> findShipedOrderStatus();
	
	
	@Query("select u from OrderStatus u where u.statusType=3")
	List<OrderStatus> findDeliveredOrderStatus();
	
	
	
	

	
	
	@Query("select u from OrderStatus u where u.isCanceled=1")
	List<OrderStatus> canceledOrder();
	
}
