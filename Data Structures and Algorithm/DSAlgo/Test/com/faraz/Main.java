package com.faraz;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1 for question 1.");
		System.out.println("Enter 2 for question 2.");
		System.out.print("\nEnter your choice: ");
		int q = sc.nextInt();

		if (q == 1) {
			SingleLL sll = new SingleLL();
			while (true) {
				System.out.println("\nEnter 1 to insert data at first.");
				System.out.println("Enter 2 to insert data at last.");
				System.out.println("Enter 3 to delete data at first.");
				System.out.println("Enter 4 to delete data at last.");
				System.out.println("Enter 5 to show items in list.");
				System.out.println("Enter 6 to exit.");

				System.out.print("\nEnter your choice: ");
				int choice = sc.nextInt();

				if (choice == 1) {
					System.out.print("Enter data to insert: ");
					int data = sc.nextInt();
					sll.insertionAtFirst(data);
				} else if (choice == 2) {
					System.out.print("Enter data to insert: ");
					int data = sc.nextInt();
					sll.insertionAtLast(data);
				} else if (choice == 3) {
					sll.deletionAtFirst();
				} else if (choice == 4) {
					sll.deletionAtLast();
				} else if (choice == 5) {
					sll.show();
				} else if (choice == 6) {
					System.out.println("Exiting...");
					break;
				} else {
					System.out.println("Invalid choice...");
				}
			}
		} else if (q == 2) {
			TransposeMatrix tm = new TransposeMatrix();
			tm.insertdata();
			tm.findTranspose();
			tm.showOriginalMatrix();
			tm.showTransposedMatrix();
		}

	}

}
