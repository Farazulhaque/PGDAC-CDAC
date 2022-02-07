package com.cdac.springassignment;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private int pId;
	private String pName;
	private int price;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void execute() {
		System.out.println("Product is executed");
	}
}
