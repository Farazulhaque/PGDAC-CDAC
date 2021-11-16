package com.fa;

public class Factor {

	// Created sll1 and sll2 to store factors of number1 and number2
	SLL sll1 = new SLL();
	SLL sll2 = new SLL();
	// Created sll3 to store common numbers from sll1 and sll2
	SLL sll3 = new SLL();

	public void findHCF(int num1, int num2) {
		// loop from 1 to num1
		// and if any number that divide the original number evenly or exactly
		// then add that number to sll1
		for (int i = 1; i <= num1; i++) {
			if (num1 % i == 0) {
				sll1.append(i);
			}
		}
		// sll1.show();

		// loop from 1 to num2
		// and if any number that divide the original number evenly or exactly
		// then add that number to sll2
		for (int i = 1; i <= num2; i++) {
			if (num2 % i == 0) {
				sll2.append(i);
			}
		}
		// sll2.show();

		// Now create a node tr1 and tr2 to
		// find common numbers
		// start from head of sll1
		// and loop until last that is null value
		Node tr1 = sll1.head;
		while (tr1 != null) {
			// On each iteration start from head of sll2
			// so that we can check each number
			// and loop until last that is null value
			Node tr2 = sll2.head;
			while (tr2 != null) {
				// Now compare data of sll1 to data of sll2
				// that stores factors of both numbers
				// if equal then add that number to sll3
				if (tr1.data == tr2.data) {
					sll3.append(tr1.data);
				}
				// set tr2 to next node on each iteration
				tr2 = tr2.link;
			}
			// set tr1 to next node on each iteration
			tr1 = tr1.link;
		}
		// sll3.show();

		// Now again create another node to find
		// hcf of both numbers
		Node tr3 = sll3.head;
		// set hcf to first data of tr3
		int hcf = tr3.data;
		while (tr3 != null) {
			// Now comapre hcf with each data
			// and if it is less than any data
			// then replace value stored in hcf to
			// that data
			if (hcf < tr3.data) {
				hcf = tr3.data;
			}
			// set tr3 to next node on each iteration
			tr3 = tr3.link;
		}

		// Print final result i.e HCF of num1 and num2
		System.out.println("HCF of " + num1 + " and " + num2 + " is " + hcf);

	}
}
