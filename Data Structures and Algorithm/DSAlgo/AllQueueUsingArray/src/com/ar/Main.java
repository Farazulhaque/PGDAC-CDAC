package com.ar;

public class Main {
	public static void main(String[] args) {
		// SimpleQ sq = new SimpleQ();
		CircularQ cq = new CircularQ();
		int item;
		try {
			cq.enqueue(10);
			cq.enqueue(20);
			item = cq.dequeue();
			System.out.println("Deleted item = " + item);
			System.out.println("Deleted item = " + cq.dequeue());
			item = cq.dequeue();
			System.out.println("Success");
		} catch (OverFlowException | UnderFlowException e) {
			System.out.println(e);
		} finally {
			System.out.println("OVER");
		}
		// ----------------------------------------------------------------
		DoubleEndedQ dq = new DoubleEndedQ();
		try {
			dq.enqueueFromEnd(10);
			dq.enqueueFromEnd(20);
			dq.enqueueFromEnd(30);
			dq.enqueueFromEnd(40);
			System.out.println("After inserting 10, 20, 30, 40 from end");
			dq.display();
			System.out.println("--");
			dq.enqueueFromFront(100);
			System.out.println("After inserting 100 from front");
			dq.display();
			System.out.println("--");

			System.out.println("Deleted item = " + dq.dequeueFromFront());
			System.out.println("Deleted item = " + dq.dequeueFromFront());
			System.out.println("After deleting item from front 2 times");
			dq.display();
			System.out.println("Deleted item = " + dq.dequeueFromEnd());
			System.out.println("After deleting item from end 1 time");
			dq.display();
		} catch (OverFlowException | UnderFlowException e) {
			System.out.println(e);
		}

	}
}
