package com.ph;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello....");
		MyList l1 = new MyList();

		// MyList l2 = new MyList();
		try {
			l1.insertItemAtEnd(10);
			System.out.println("\nInserted 1 item at end.");
			l1.show();

			l1.insertItemAtEnd(20);
			System.out.println("\nInserted 2 item at end.");
			l1.show();
			l1.insertItemAtEnd(30);
			System.out.println("\nInserted 3 item at end.");
			l1.show();
			l1.insertItemAtBeginning(100);
			System.out.println("\nInserted 1 item at beginning");
			l1.show();
			// l1.insertItemAfterAnotherItem(200, 200);
			l1.insertItemAfterAnotherItem(200, 100);
			System.out.println("\nInserted 1 item after another item");
			l1.show();
			l1.insertItemBeforeAnotherItem(300, 10);
			System.out.println("\nInserted 1 item before another item");
			l1.show();
			l1.insertItemAtEnd(40);
			System.out.println("\nInserted 4 item at end.");
			l1.show();
			l1.insertItemAtEnd(50);
			System.out.println("\nInserted 5 item at end.");
			l1.show();
			l1.insertItemAtEnd(60);
			System.out.println("\nInserted 6 item at end.");
			l1.show();
			l1.insertItemAtSpecificPosition(400, 3);
			System.out.println("\nInserted 1 item at specific position.");
			l1.show();
			l1.deleteItemAtEnd();
			System.out.println("\nDeleted item at end");
			l1.show();
			l1.deleteItemAtBeginning();
			System.out.println("\nDeleted 1 item at beginning");
			l1.show();

			l1.deleteItemAtSpecificPosition(8);
			System.out.println("\nDeleted 1 item at position 8 or index 7.");
			l1.show();

			System.out.println("\nSearching item 10...");
			l1.searchItem(10);

			System.out.println("Searching item at position 2...");
			l1.searchPositionOfItem(2);

			l1.emptyEntireList();
		} catch (SpaceFullException | EmptyArrayException | InterruptedException e) {
			System.out.println(e);
		}
		l1.show();

	}

}