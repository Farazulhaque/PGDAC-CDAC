package com.ar;

public class CircularQ {
	private int[] array;
	private int front;
	private int rear;

	public CircularQ() {
		array = new int[3];
		front = rear = -1;
	}

	public void enqueue(int item) throws OverFlowException {
		int bi = (front == 0) ? array.length - 1 : front - 1;
		if (bi == rear) {
			throw new OverFlowException();
		} else {
			array[++rear] = item;
			if (front == -1) // if CQ was earlier empty
				front = 0;
		}
	}

	public int dequeue() throws UnderFlowException {

		if (front == -1) {
			throw new UnderFlowException();
		} else {
			int item = array[front]; // item at front is copied

			// case1: is CQ has single item
			if (front == rear) {
				front = rear = -1;
			}

			// case2: CQ has more than 1 item
			else {

				// front++;
				// if (front == array.length) {
				// front = 0;
				// }

				// if (front == array.length - 1)
				// front = -1;
				// front++;

				front = (front == array.length - 1) ? 0 : front + 1;
			}
			return item;
		}
	}
}
