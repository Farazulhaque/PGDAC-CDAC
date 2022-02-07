package com.cdac.springassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sales {
	private int sId;
	@Autowired
	private PersonDetails salePerson;
	@Autowired
	private Product product;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public PersonDetails getSalePerson() {
		return salePerson;
	}

	public void setSalePerson(PersonDetails salePerson) {
		this.salePerson = salePerson;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void show() {
		System.out.println("Sales is running");
		product.execute();
		salePerson.execute();
	}
}
