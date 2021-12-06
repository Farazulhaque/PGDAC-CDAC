package com.faraz;

public class SingleLL {
	// create first node/ head node
	Node head;

	// on object creation set head to null
	public SingleLL() {
		head = null;
	}

	// method to insert data at beginning
	public void insertionAtFirst(int data) {
		// check list is empty or not
		if (head == null) {
			// if empty then create new node with data and store in head
			head = new Node(data);
		} else {
			// else create new node with data
			Node first = new Node(data);
			// and then link it to first node i.e head of sll
			first.link = head;
			// and then set head to first
			head = first;
		}
		System.out.println(data + " inserted at beginning...");
	}

	public void deletionAtFirst() {
		// check is sll is empty or not
		if (head == null) {
			// if empty then print list empty
			System.out.println("List is empty...");
		} else {
			// else store the first data into new variable
			int first = head.data;
			// then create temporary node to store head
			Node temp = head;
			// and then set head to next node i.e head.link
			head = head.link;
			// and then set null to temporary variables
			temp.link = null;
			temp = null;
			System.out.println(first + " deleted from beginning...");
		}
	}

	public void insertionAtLast(int data) {
		// check if list is empty or not
		if (head == null) {
			// if empty then create new node and set it to head
			head = new Node(data);
		} else {
			// else iterate till last node
			Node last;
			for (last = head; last.link != null; last = last.link)
				;
			// and then set link of last node to new node of data
			last.link = new Node(data);
		}
		System.out.println(data + " inserted at Last...");
	}

	public void deletionAtLast() {
		// check if list is empty or not
		if (head == null) {
			// if empty then print list empty
			System.out.println("List is empty...");
		} else {
			// else create two node to iterate till last node and second last node
			Node pr = null;
			Node tr = head;
			for (tr = head; tr.link != null; tr = tr.link) {
				pr = tr;
			}

			// and then set data to last data
			int lastData = tr.data;
			System.out.println(lastData + " deleted from Last...");
			// and set link of second last node to null
			pr.link = null;
			// and also last node to null
			tr = null;
		}
	}

	// method to print items stored in list
	public void show() {
		System.out.print("Items in Single Linked List: ");

		if (head == null) {
			System.out.println("List is empty");
		} else {
			Node tr;
			for (tr = head; tr != null; tr = tr.link) {
				System.out.print(tr.data + " ");
			}
		}

		System.out.println();
	}

}
