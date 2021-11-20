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

			// l1.insertItemAtEnd(83);
			// l1.insertItemAtEnd(53);
			// l1.insertItemAtEnd(51);
			// l1.insertItemAtEnd(32);
			// l1.insertItemAtEnd(18);

			// l1.insertItemAtEnd(70);
			// l1.insertItemAtEnd(66);
			// l1.insertItemAtEnd(45);
			// l1.insertItemAtEnd(35);
			// l1.insertItemAtEnd(14);

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


			l1.heapSort();
			System.out.println("\nPriting all array elements after heap sort");
			l1.show();

		} catch (SpaceFullException e) {
			System.out.println(e);
		}
	}
}