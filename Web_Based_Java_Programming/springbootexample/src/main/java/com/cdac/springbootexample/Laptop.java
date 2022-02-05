package com.cdac.springbootexample;

import org.springframework.stereotype.Component;

@Component("lappy")
public class Laptop {
	private int lid;
	private String lcompany;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLcompany() {
		return lcompany;
	}

	public void setLcompany(String lcompany) {
		this.lcompany = lcompany;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lcompany=" + lcompany + "]";
	}
	
	public void execute() {
		System.out.println("It is running...");
	}
}
