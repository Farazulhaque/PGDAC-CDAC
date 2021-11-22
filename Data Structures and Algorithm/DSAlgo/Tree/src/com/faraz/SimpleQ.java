package com.faraz;

public class SimpleQ {
	private Node[] array;
	public int front;
	private int rear;

	public SimpleQ() {
		array = new Node[50];
		// front = rear = -1 is empty queue condition
		front = rear = -1;
	}

	public void enqueue(Node R) {
		front = 0;
		array[++rear] = R;
	}

	public Node dequeue() {
		Node R = array[front]; // Node at front is copied
		for (int i = front; i < rear; i++) {// remaining all nodes shifted towards frontend
			array[i] = array[i + 1];
		}
		rear--;
		if (rear == -1) // if q has only one node and that is being removed
			front = -1;

		return R;
	}
}
