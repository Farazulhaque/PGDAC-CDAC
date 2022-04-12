package com.medibox.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderdetailId;
	
	private int medicineQuantity;

	private  float medicnePrice;
	
	private int  medicineDiscount;
	
	@ManyToOne
	private MedicineMaster medicineMaster;
	
	@ManyToOne
	private OrderMaster orderMaster;

	public long getOrderdetailId() {
		return orderdetailId;
	}

	public void setOrderdetailId(long orderdetailId) {
		this.orderdetailId = orderdetailId;
	}

	public int getMedicineQuantity() {
		return medicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}

	public float getMedicnePrice() {
		return medicnePrice;
	}

	public void setMedicnePrice(float medicnePrice) {
		this.medicnePrice = medicnePrice;
	}

	public int getMedicineDiscount() {
		return medicineDiscount;
	}

	public void setMedicineDiscount(int medicineDiscount) {
		this.medicineDiscount = medicineDiscount;
	}

	public MedicineMaster getMedicineMaster() {
		return medicineMaster;
	}

	public void setMedicineMaster(MedicineMaster medicineMaster) {
		this.medicineMaster = medicineMaster;
	}

	public OrderMaster getOrderMaster() {
		return orderMaster;
	}

	public void setOrderMaster(OrderMaster orderMaster) {
		this.orderMaster = orderMaster;
	}





}
