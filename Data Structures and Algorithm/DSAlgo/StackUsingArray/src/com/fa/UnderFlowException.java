package com.fa;

public class UnderFlowException extends Exception {
    static final long serialVersionUID = 1100001L;

	@Override
	public String toString() {
		return "STACK EMPTY";
	}
}
