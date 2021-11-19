package com.graph.stack;

import com.graph.matrix.Edge;

public class Stack {
	Node top;

	public Stack() {
		top = null; // Empty Stack
	}

	public void push(Edge data) { // addAtBeg of SLL
		if (top == null)
			top = new Node(data); // first node
		else {
			Node newNode = new Node(data);
			newNode.link = top;
			top = newNode;
		}
	}

	public Edge pop() { // deleteAtBeg of SLL
		if (top == null) {
			System.out.println("Stack is EMPTY");
			return null;
		} else {
			Edge data = top.data; // copy data of first node
			Node temp = top;
			top = top.link; // advance head to next node
			temp.link = null; // break the reference
			temp = null; // GC will automatically clean the object
			return data;
		}
	}

	public boolean isEmpty() {
		return (top == null) ? true : false;
	}
}
