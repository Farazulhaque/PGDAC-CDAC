
package com.medibox.admin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(nullable = false)
	private String fullName;

	@Column(nullable = false, unique = true)
	private String emailId;

	@Column(nullable = false, unique = true)
	private String contactNumber;

	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserAddress> userAddresses;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<OrderMaster> orderMaster;

	public List<OrderMaster> getOrderMaster() {
		return orderMaster;
	}

	public void setOrderMaster(List<OrderMaster> orderMaster) {
		this.orderMaster = orderMaster;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

}
