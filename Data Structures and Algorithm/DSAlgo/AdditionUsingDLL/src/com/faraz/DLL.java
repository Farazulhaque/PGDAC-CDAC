package com.faraz;

public class DLL {
	NodeDLL head;

	public DLL() {
		head = null;
	}

	public void append(int new_data) {
		NodeDLL new_node = new NodeDLL(new_data);

		NodeDLL last = head;

		// This new node is going to be the last node, so make next of it as NULL
		new_node.next_link = null;

		// If the Linked List is empty, then make the new node as head
		if (head == null) {
			new_node.prev_link = null;
			head = new_node;
			return;
		}

		// Else traverse till the last node
		while (last.next_link != null)
			last = last.next_link;

		// Change the next of last node
		last.next_link = new_node;

		// Make last node as previous of new node
		new_node.prev_link = last;
	}

	public int getLastNumber() {
		NodeDLL last = head;

		// traverse till the last node
		while (last.next_link != null)
			last = last.next_link;

		// store last data of last node into number variable
		int number = last.data;

		// for head condition. i.e if it is the only number left in DLL
		// then its previous link is already null so set next link to null
		if (last.prev_link == null) {
			last.data = 0;
		}
		// else set last link of last node from second last node to null
		else {
			last.prev_link.next_link = null;
		}
		return number;
	}

	public void addAtBegin(int data) {
		NodeDLL first = new NodeDLL(data);
		if (head == null) {
			first.prev_link = null;
			head = first;
			return;
		}
		first.next_link = head;
		first.prev_link = null;
		head = first;

	}

	public void show() {
		// traverse in SLL until SLL not over
		// if starting or first number is not zero
		if (head.data != 0) {
			for (NodeDLL tr = head; tr != null; tr = tr.next_link) {
				System.out.print(tr.data);
			}
		} 
		// if first number is zero then start printing from next number
		else {
			for (NodeDLL tr = head.next_link; tr != null; tr = tr.next_link) {
				System.out.print(tr.data);
			}
		}

	}
}
