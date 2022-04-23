package com.medibox.admin.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.OrderDetails;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	
	@Query("select u from OrderDetails u where u.orderdetailId=?1")
	OrderDetails findOrderDetailsById(Integer orderdetailId );
	
	
	
}


