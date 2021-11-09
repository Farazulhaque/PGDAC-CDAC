package com.fa;

public class MyQueue {
	Node front, rear;

	public MyQueue() {
		front = rear = null;
	}

	public void enqueue(int item) {
		Node newNode = new Node(item);
		// if queue is empty
		if (rear == null) {
			front = rear = newNode;
		} else {
			rear.link = newNode;
			rear = newNode;
		}
	}

	public void dequeue() {
		if (front == null) {
			return;
		} else {
			front = front.link;
			if (front == null) {
				rear = null;
			}
		}
	}

	public void show() {
		for (Node i = front; rear != null; i = front.link, rear = rear.link) {
			System.out.println(i.data);
		}
	}

}
