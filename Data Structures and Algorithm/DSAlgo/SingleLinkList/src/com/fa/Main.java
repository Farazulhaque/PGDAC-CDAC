package com.fa;

public class Main {

	public static void main(String[] args) {
		// Node head = null;
		//
		// head = new Node(100); // Node1 created
		// head.link = new Node(200);// Node2 created
		// head.link.link = new Node(300);// Node3 created
		// head.link.link.link = new Node(400);// Node4 created
		//
		//// show SLL
		// System.out.println("Single Linked List -->");
		// for (Node tr = head; tr != null; tr = tr.link) {
		// System.out.print(tr.data + ", ");
		//// System.out.println(" :: " + tr.link);
		// }
		//// Node tr = head --> reference first node
		//// tr != null --> while SLL is not finished
		//// tr = tr.link --> advance tr to next node

		SLL l1 = new SLL();
		// System.out.println("-------------SINGLE LINKLIST---------------");
		l1.append(100);
		l1.append(200);
		l1.append(300);
		l1.append(400);
		l1.addAtBegin(10);
		l1.addAtBegin(5);
		System.out.println("Single Linked List -->");
		// l1.show();
		// try {
		// int dd = l1.deleteAtBegin();
		// System.out.println("Deleted Data at begin: " + dd);
		// } catch (EmptyLinkListException e) {
		// System.out.println(e);
		// }
		l1.show();
		System.out.println("-----");
		try {
			l1.insertItemBeforeAnotherItem(500, 200);
		} catch (EmptyLinkListException e) {
			System.out.println(e);
		}
		l1.show();
		System.out.println("-----");
		try {
			l1.insertItemAfterAnotherItem(20, 10);
		} catch (EmptyLinkListException e) {
			System.out.println(e);
		}
		l1.show();

		System.out.println("-------------------STACK-------------------");
		MyStack s = new MyStack();
		s.push(100);
		s.push(200);
		System.out.println("Popped data = " + s.pop());
		System.out.println("Over...");

		System.out.println("-------------------QUEUE-------------------");
		MyQueue q = new MyQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		// q.show();
		// q.dequeue();
		// q.dequeue();
		q.dequeue();
		System.out.println("Queue Front : " + q.front.data);
		System.out.println("Queue Rear : " + q.rear.data);

		System.out.println("-------------All methods of DLL------------");
		DLL l2 = new DLL();
		l2.append(10);
		l2.append(20);
		l2.append(30);
		l2.append(40);
		l2.addAtBegin(100);
		l2.deleteAtBegin();
		l2.insertItemAfterAnotherItem(40, 10);
		l2.insertItemBeforeAnotherItem(400, 20);
		l2.show();
	}

}
