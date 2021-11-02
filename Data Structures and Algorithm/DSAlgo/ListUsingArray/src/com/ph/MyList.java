package com.ph;

import com.ph.exception.EmptyArrayException;
import com.ph.exception.SpaceFullException;

public class MyList {

	private int[] array;
	private int noOfItem;

	public MyList() {
		noOfItem = 0;
		array = new int[10];
	}

	public MyList(int size) {
		noOfItem = 0;
		array = new int[size];
	}

	// check is storage has space
	public boolean isSpace() {
		return (noOfItem < array.length) ? true : false;
	}

	public boolean isEmpty() {
		return (noOfItem == 0) ? true : false;
	}

	public void insertItemAtEnd(int item) throws SpaceFullException {
		if (isSpace()) {
			// store item at noOfItem location
			array[noOfItem] = item;
			// update number of items
			noOfItem++;
		} else {
			throw new SpaceFullException();
		}
	}

	public void insertItemAtBeginning(int item) throws SpaceFullException {
		if (isSpace()) {
			// shifting all items from last by 1 position
			for (int i = noOfItem; i > 0; i--) {
				array[i] = array[i - 1];
			}
			// store item at 0th index of array
			array[0] = item;
			// update number of items
			noOfItem++;
		} else {
			throw new SpaceFullException();
		}
	}

	public void insertItemAfterAnotherItem(int item, int afterItem) throws SpaceFullException {
		if (isSpace()) {
			boolean flag = false;
			// loop to check another item is present or not
			for (int i = 0; i < noOfItem; i++) {
				// if matched
				if (array[i] == afterItem) {
					// loop to shift all elements from last by 1 position
					// j > i + 1 because we want to add element after element at ith position
					for (int j = noOfItem; j > i + 1; j--) {
						array[j] = array[j - 1];
					}
					// assign item to [i +1] position
					array[i + 1] = item;
					// increment number of items
					noOfItem++;
					flag = true;
					return;
				}
			}
			if (flag == false) {
				System.out.println(afterItem + " is not available in the array.");
			}

		} else {
			throw new SpaceFullException();
		}
	}

	public void insertItemBeforeAnotherItem(int item, int beforeItem) throws SpaceFullException {
		if (isSpace()) {
			boolean flag = false;
			// loop to check another item is present or not
			for (int i = 0; i < noOfItem; i++) {
				// if matched
				if (array[i] == beforeItem) {
					// loop to shift all elements from last by 1 position
					// j > i + 1 because we want to add element after element at ith position
					for (int j = noOfItem; j > i - 1; j--) {
						array[j] = array[j - 1];
					}
					// assign item to [i +1] position
					array[i] = item;
					// increment number of items
					noOfItem++;
					flag = true;
					return;
				}
			}
			if (flag == false) {
				System.out.println(beforeItem + " is not available in the array.");
			}

		} else {
			throw new SpaceFullException();
		}
	}

	public void insertItemAtSpecificPosition(int item, int position) throws SpaceFullException {
		if (isSpace()) {
			for (int i = noOfItem; i > position; i--) {
				array[i] = array[i - 1];
			}
			array[position] = item;
			noOfItem++;

		} else {
			throw new SpaceFullException();
		}
	}

	// public void deleteItemAtEnd() {
	// array[noOfItem-1] = 0;
	// }

	// public void deleteItemAtEnd() throws SpaceFullException {
	// if (isEmpty()) {
	// int i, j;

	// for (j = 0; j < noOfItem; j++) {
	// if (array[j] == item)
	// break;
	// }

	// for (i = j; i < noOfItem; i++)
	// array[i] = array[i + 1];

	// noOfItem--;

	// } else
	// throw new SpaceFullException();
	// }

	public void deleteItemAtBeginning() throws EmptyArrayException {
		if (!isEmpty()) {
			for (int i = 1; i < noOfItem; i++) {
				array[i - 1] = array[i];
			}
			noOfItem--;
		} else {
			throw new EmptyArrayException();
		}
	}

	public void deleteItemAtSpecificPosition(int position) throws EmptyArrayException {
		if (!isEmpty()) {
			for (int i = position - 1; i < noOfItem - 1; i++) {
				array[i] = array[i + 1];
			}
			noOfItem--;

		} else {
			throw new EmptyArrayException();
		}
	}

	public void show() {
		System.out.println("Priting all array elements");
		for (int i = 0; i < noOfItem; i++) {
			System.out.println("Array[" + i + "] = " + array[i]);
		}
		// System.out.println(array[9]);
	}

}