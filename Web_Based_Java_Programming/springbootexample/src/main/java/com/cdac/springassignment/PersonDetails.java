package com.cdac.springassignment;

import org.springframework.stereotype.Component;

@Component
public class PersonDetails {
	private String name;
	private String email;
	private int contact;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void execute() {
		System.out.println("Person details executed");
	}
}
