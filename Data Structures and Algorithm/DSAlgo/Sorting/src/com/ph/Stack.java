package com.ph;

public class Stack {
	Bound arr[];
	int top;

	public Stack() {
		top = -1;
		arr = new Bound[100];
	}

	public void push(Bound d) {
		arr[++top] = d;
	}

	public Bound pop() {
		Bound d = arr[top--];
		return d;
	}

	public boolean isStackEmpty() {
		return (top == -1) ? true : false;
	}

}