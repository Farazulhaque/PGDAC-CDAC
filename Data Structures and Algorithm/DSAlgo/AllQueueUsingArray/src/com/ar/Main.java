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
	}
}
