package com.fa.poly;

public class PolyTerm {
	public int coef;
	public String var;
	public int exp;

	public PolyTerm(int coef, String var, int exp) {
		this.coef = coef;
		this.var = var;
		this.exp = exp;
	}

	public PolyTerm(int coef, String var) {
		this.coef = coef;
		this.var = var;
		this.exp = 1;
	}

	public PolyTerm(int coef) {
		this.coef = coef;
		this.var = "";
		this.exp = 0;
	}
	
	public PolyTerm(PolyTerm t) {
		this.coef = t.coef;
		this.var = t.var;
		this.exp = t.exp;
	}
}
