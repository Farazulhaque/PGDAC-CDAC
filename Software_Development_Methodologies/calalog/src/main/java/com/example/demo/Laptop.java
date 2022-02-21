package com.example.demo;

public class Laptop {
	int lid;
	String lbrand;
	float lprice;

	public Laptop(int lid, String lbrand, float lprice) {
		super();
		this.lid = lid;
		this.lbrand = lbrand;
		this.lprice = lprice;
	}

	public int getlid() {
		return lid;
	}

	public void setlid(int lid) {
		this.lid = lid;
	}

	public String getlbrand() {
		return lbrand;
	}

	public void setlbrand(String lbrand) {
		this.lbrand = lbrand;
	}

	public float getlprice() {
		return lprice;
	}

	public void setlprice(float lprice) {
		this.lprice = lprice;
	}
}
