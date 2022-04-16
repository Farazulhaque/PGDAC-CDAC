package com.medibox.admin.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.OrderDetails;
import com.medibox.admin.model.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {

	@Query("select u from OrderMaster u where u.orderId=?1")
	OrderMaster findOrderMasterById(Integer orderId);

	@Query("select count(s) from OrderMaster s ")
	int OrderMasterCount();

	@Query("select u from OrderMaster u where u.status.statusType=?1")
	List<OrderMaster> pendingListOfOrderMaster();

	@Query("select u from OrderMaster u ")
	List<OrderMaster> LIST();
}
