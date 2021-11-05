package com.ar;

public class SimpleQ {
	private int[] array;
	private int front;
	private int rear;

	public SimpleQ() {
		array = new int[3];
		front = rear = -1;
	}

	public void enqueue(int item) throws OverFlowException {
		if (rear == array.length - 1) {
			throw new OverFlowException();
		} else {
			front = 0;
			array[++rear] = item;
		}
	}

	public int dequeue() throws UnderFlowException {
		if (front == -1) {
			throw new UnderFlowException();
		} else {
			int item = array[front]; // item at front is copied
			for (int i = front; i < rear; i++) {// remaining all items shifted towards frontend
				array[i] = array[i + 1];
			}
			rear--;
			if (rear == -1) // if q has only one item and that is being removed
				front = -1;

			return item;
		}
	}
}
