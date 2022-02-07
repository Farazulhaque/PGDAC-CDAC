package com.cdac.springassignment;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private int streetNo;
	private String city;
	private String state;

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void show() {
		System.out.println("Address is running");
	}
}
