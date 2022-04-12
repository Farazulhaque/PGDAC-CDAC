package com.medibox.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SellerMedicneManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerMediManagerId;
	
	@Column(nullable = false)
	private int qunatity;
	
	@Column(nullable = false)
	private int sellerDiscount;
	
	@ManyToOne
	private Seller seller;
	
	@ManyToOne
	private MedicineMaster medicineMaster;

	public int getSellerMediManagerId() {
		return sellerMediManagerId;
	}

	public void setSellerMediManagerId(int sellerMediManagerId) {
		this.sellerMediManagerId = sellerMediManagerId;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	public int getSellerDiscount() {
		return sellerDiscount;
	}

	public void setSellerDiscount(int sellerDiscount) {
		this.sellerDiscount = sellerDiscount;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public MedicineMaster getMedicineMaster() {
		return medicineMaster;
	}

	public void setMedicineMaster(MedicineMaster medicineMaster) {
		this.medicineMaster = medicineMaster;
	}

	@Override
	public String toString() {
		return "SellerMedicneManager [sellerMediManagerId=" + sellerMediManagerId + ", qunatity=" + qunatity
				+ ", sellerDiscount=" + sellerDiscount + ", seller=" + seller + ", medicineMaster=" + medicineMaster
				+ "]";
	}

	
	
	
	
	
	///////////////////////////////////////////////////////////////

	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
