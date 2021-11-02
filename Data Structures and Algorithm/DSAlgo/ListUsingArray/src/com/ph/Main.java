package com.ph;

import com.ph.exception.SpaceFullException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello....");
		MyList l1 = new MyList();

//		MyList l2 = new MyList();
		try {
			l1.insertItemAtEnd(10);
			System.out.println("Inserted 1 item.");
			l1.insertItemAtEnd(20);
			System.out.println("Inserted 2 item.");
			l1.insertItemAtEnd(30);
			System.out.println("Inserted 3 item.");
			l1.insertItemAtEnd(40);
			System.out.println("Inserted 4 item.");
			l1.insertItemAtEnd(50);
			System.out.println("Inserted 5 item.");
			l1.insertItemAtEnd(60);
			System.out.println("Inserted 6 item.");

		} catch (SpaceFullException e) {
			System.out.println(e); 
		}

	}

}