package com.ph;

import com.ph.exception.SpaceFullException;

public class MyList {

	private int[] array;
	private int noOfItem;

	public MyList() {
		noOfItem = 0;
		array = new int[5];
	}

	public MyList(int size) {
		noOfItem = 0;
		array = new int[size];
	}

//	check is storage has space
	public boolean isSpace() {
		return (noOfItem < array.length) ? true : false;
	}

	public void insertItemAtEnd(int item) throws SpaceFullException {
		if (isSpace()) {
			array[noOfItem++] = item;
		} else
			throw new SpaceFullException();
	}

}