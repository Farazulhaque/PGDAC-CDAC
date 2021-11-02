package com.ph.exception;

//custom exception
public class SpaceFullException extends Exception {
	static final long serialVersionUID = 1100001L;

	@Override
	public String toString() {
		return "Space is Full. \nExiting...\n";
	}
}