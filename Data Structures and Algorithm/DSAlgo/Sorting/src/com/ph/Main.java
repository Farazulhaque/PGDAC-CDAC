package com.ph;

public class Main {

	public static void main(String[] args) {
		MyList l1 = new MyList(11);

		try {
			l1.insertItemAtEnd(8);
			l1.insertItemAtEnd(900);
			l1.insertItemAtEnd(78);
			l1.insertItemAtEnd(90);
			l1.insertItemAtEnd(34);
			l1.insertItemAtEnd(7);
			l1.insertItemAtEnd(2);
			l1.insertItemAtEnd(8);
			l1.insertItemAtEnd(3445);
			l1.insertItemAtEnd(8);
			l1.insertItemAtEnd(200);
			System.out.println("\nPriting all array elements before sort");
			l1.show();
			// System.out.println("\nPriting all array elements after bubble sort");
			// l1.bubbleSort();
			// l1.show();
			// System.out.println("\nPriting all array elements after selection sort");
			// l1.selectionSort();
			// l1.show();
			// System.out.println("\nPriting all array elements after quick sort");
			// l1.quickSort();

			// System.out.println("\nPriting all array elements after insertion sort");
			// l1.insertionSort();

			// System.out.println("\nPriting all array elements after merge sort");
			// l1.mergeSort();

			System.out.println("\nPriting all array elements after heap sort");
			l1.heapSort();

			l1.show();

		} catch (SpaceFullException e) {
			System.out.println(e);
		}
	}
}