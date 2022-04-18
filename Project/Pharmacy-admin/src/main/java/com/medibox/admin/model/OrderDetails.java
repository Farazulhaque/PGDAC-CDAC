package com.medibox.admin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.Query;

@Entity
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderdetailId;

	private int medicineQuantity;

	private float medicnePrice;

	private float medicineDiscount;

	@ManyToOne
	private MedicineMaster medicineMaster;

	@ManyToOne
	private OrderMaster orderMaster;

	public int getOrderdetailId() {
		return orderdetailId;
	}

	public void setOrderdetailId(int orderdetailId) {
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

	public float getMedicineDiscount() {
		return medicineDiscount;
	}

	public void setMedicineDiscount(float medicineDiscount) {
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
