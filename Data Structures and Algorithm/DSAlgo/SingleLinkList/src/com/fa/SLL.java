package com.fa;

public class SLL {
	Node head;

	public SLL() {
		head = null;
	}

	public void append(int data) {
		// empty list condition
		if (head == null)
			head = new Node(data); // first node
		else {
			Node tr;
			// traverse in SLL & reach to the last node
			for (tr = head; tr.link != null; tr = tr.link)
				;
			// Now tr will be referencing to the last node
			// create and attach a new node with the last node
			tr.link = new Node(data);
		}
	}

	public void addAtBegin(int data) {
		// empty list condition
		if (head == null)
			head = new Node(data); // first node
		else {
			Node newNode = new Node(data);
			newNode.link = head;
			head = newNode;
		}
	}

	public int deleteAtBegin() throws EmptyLinkListException {
		// empty list condition
		if (head == null) {
			throw new EmptyLinkListException();
			// System.out.println("SLL is EMPTY");
			// return 0;
		} else {
			int data = head.data; // copy data of first node
			Node temp = head;
			head = head.link; // advance head to next node
			temp.link = null; // break reference --> deleted temp
			temp = null; // Garbage collector automatically clean the memory
			return data;
		}
	}

	public void insertItemBeforeAnotherItem(int newData, int oldData) throws EmptyLinkListException {
		// empty list condition
		if (head == null) {
			throw new EmptyLinkListException();
			// System.out.println("SLL is EMPTY");
			// return 0;
		} else {
			Node pr;
			Node tr = head;
			pr = null;
			while (tr.data != oldData && tr != null) {
				pr = tr;
				tr = tr.link;
			}
			if (tr == null) {
				// item not found
			} else {
				Node newNode = new Node(newData);
				newNode.link = pr.link;
				pr.link = newNode;
			}
		}
	}

	public void insertItemAfterAnotherItem(int newData, int oldData) throws EmptyLinkListException {
		// empty list condition
		if (head == null) {
			throw new EmptyLinkListException();
			// System.out.println("SLL is EMPTY");
			// return 0;
		} else {
			Node tr = head;
			while (tr.data != oldData && tr != null) {
				tr = tr.link;
			}
			if (tr == null) {
				// item not found
			} else {
				Node newNode = new Node(newData);
				newNode.link = tr.link;
				tr.link = newNode;
			}
		}
	}

	public void show() {
		// traverse in SLL until SLL not over
		for (Node tr = head; tr != null; tr = tr.link)
			System.out.println(tr.data);
	}
}
