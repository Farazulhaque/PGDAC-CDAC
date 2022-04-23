package com.medibox.admin.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;

	@Column(nullable = false)
	private String fullName;

	@Column(nullable = false,unique = true)
	private String emailId;

	@Column(nullable = false)
	private String password;

	@Column(columnDefinition = "integer default 0") 
	private int status;

	@Column(nullable = false)
	private String shopName;

	@Column(nullable = false)
	private String shopeRegNo;

	@Column(nullable = false)
	private String shopContactNo;

	@Column(nullable = false, length = 500)
	private String shopAddress;

	@Column(nullable = false,unique = true)
	private int shopPincode;

	// @Column(nullable = false)
	private String documentUrl;

	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<SellerMedicneManager> sellerMedicneManager;

	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderMaster> orderMaster;

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopeRegNo() {
		return shopeRegNo;
	}

	public void setShopeRegNo(String shopeRegNo) {
		this.shopeRegNo = shopeRegNo;
	}

	public String getShopContactNo() {
		return shopContactNo;
	}

	public void setShopContactNo(String shopContactNo) {
		this.shopContactNo = shopContactNo;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public int getShopPincode() {
		return shopPincode;
	}

	public void setShopPincode(int shopPincode) {
		this.shopPincode = shopPincode;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public List<SellerMedicneManager> getSellerMedicneManager() {
		return sellerMedicneManager;
	}

	public void setSellerMedicneManager(List<SellerMedicneManager> sellerMedicneManager) {
		this.sellerMedicneManager = sellerMedicneManager;
	}

	public List<OrderMaster> getOrderMaster() {
		return orderMaster;
	}

	public void setOrderMaster(List<OrderMaster> orderMaster) {
		this.orderMaster = orderMaster;
	}

	
	
	
	

}
