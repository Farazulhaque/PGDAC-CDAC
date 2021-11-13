package com.ph;

public class EmptyArrayException extends Exception {
	static final long serialVersionUID = 1100001L;

	@Override
	public String toString() {
		return "Array is empty. \nExiting...\n";
	}
}
