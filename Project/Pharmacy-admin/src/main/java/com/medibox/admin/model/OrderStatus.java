package com.medibox.admin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long statusId;
	
	@Column()
	private String statusType;
	
	private String statusDescription;
	
	private int isActive;
	
	@OneToMany(mappedBy = "status" ,cascade = CascadeType.ALL)
	private List<OrderMaster> orderMaster;

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<OrderMaster> getOrderMaster() {
		return orderMaster;
	}

	public void setOrderMaster(List<OrderMaster> orderMaster) {
		this.orderMaster = orderMaster;
	}
	
	
	
}
