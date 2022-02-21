package com.example.demo;

public class Mobile {
	int mid;
	String mbrand;
	float mprice;

	public Mobile(int mid, String mbrand, float mprice) {
		this.mid = mid;
		this.mbrand = mbrand;
		this.mprice = mprice;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMbrand() {
		return mbrand;
	}

	public void setMbrand(String mbrand) {
		this.mbrand = mbrand;
	}

	public float getMprice() {
		return mprice;
	}

	public void setMprice(float mprice) {
		this.mprice = mprice;
	}

}
