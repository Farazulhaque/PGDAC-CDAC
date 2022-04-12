package com.medibox.admin.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class OrderMaster {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long orderId;
	
	@Column(nullable = false)
	private SimpleDateFormat orderDate ;
	
	@Column(nullable = false)
	private float  orderAmount;
	
	@Column(nullable = false)
	private int discount;
	
	@Column(nullable = false)
	private float netAmount;
	
	@Column(nullable = false)
	private LocalDate shipingDate;
	
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private UserAddress userAddress;
	
	
	@ManyToOne
	private Seller seller;
	
	@ManyToOne
	private OrderStatus status;
	
	
	@OneToMany(mappedBy = "orderMaster" ,cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;
	
	

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public SimpleDateFormat getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(SimpleDateFormat orderDate) {
		this.orderDate = orderDate;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}

	public LocalDate getShipingDate() {
		return shipingDate;
	}

	public void setShipingDate(LocalDate shipingDate) {
		this.shipingDate = shipingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
	
	
}
