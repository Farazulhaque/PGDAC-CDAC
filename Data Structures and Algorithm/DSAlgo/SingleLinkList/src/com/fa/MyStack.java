package com.fa;

public class MyStack {
	Node top;

	public MyStack() {
		top = null;
	}

	public void push(int data) { // addAtBegin of SLL
		// empty list condition
		if (top == null)
			top = new Node(data); // first node
		else {
			Node newNode = new Node(data);
			newNode.link = top;
			top = newNode;
		}
	}

	public int pop() { // deleteAtBegin of SLL
		// empty list condition
		if (top == null) {
			System.out.println("STACK is EMPTY");
			return 0;
		} else {
			int data = top.data; // copy data of first node
			Node temp = top;
			top = top.link; // advance top to next node
			temp.link = null; // break reference --> deleted temp
			temp = null; // Garbage collector automatically clean the memory
			return data;
		}
	}

}
