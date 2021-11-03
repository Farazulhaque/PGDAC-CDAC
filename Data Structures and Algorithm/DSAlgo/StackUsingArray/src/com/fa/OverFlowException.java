package com.fa;

public class OverFlowException extends Exception{
	static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "STACK FULL";
	}
}
