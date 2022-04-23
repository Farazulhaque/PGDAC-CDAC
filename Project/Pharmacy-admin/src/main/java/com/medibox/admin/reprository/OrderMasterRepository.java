package com.medibox.admin.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medibox.admin.model.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {

	@Query("select u from OrderMaster u where u.orderId=?1")
	OrderMaster findOrderMasterById(Integer orderId );
	
	@Query("select count(s) from OrderMaster s ")
	int OrderMasterCount();

	@Query("select u from OrderMaster u where u.status.statusType=0")
	List<OrderMaster> pendingListOfOrderMaster();
	
	@Query("select u from OrderMaster u ")
	List<OrderMaster> LIST();
	
	@Query("select count(u) from OrderMaster u where  u.status.statusType=0")
	int PendingOrderCount();
	
	@Query("select u from OrderMaster u where u.seller.sellerId=?1")
	List<OrderMaster> findOrderBysellerId(Integer sellerId);
	
	@Query("select u from OrderMaster u where u.user.userId=?1")
	List<OrderMaster> findOrderByUserId(Integer userId);
	
	@Query("select u from OrderMaster u where u.seller.sellerId=?1 and u.status.statusType=0")
	List<OrderMaster> findOrderBySellerPendingOrder(Integer sellerId);
	
	
	@Query("select count(u) from OrderMaster u where u.seller.sellerId=?1 and u.status.statusType=0")
	int PendingOrdersellerCount(Integer sellerId);
	
}
