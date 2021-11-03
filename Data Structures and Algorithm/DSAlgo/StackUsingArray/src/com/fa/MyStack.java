package com.fa;

public class MyStack {
	private char[] array;
	private int top;

	public MyStack() {
		array = new char[10];
		top = -1;
	}

	public void push(char item) throws OverFlowException {
		if (top == array.length - 1) {
			throw new OverFlowException();
		} else {
			array[++top] = item;
		}
	}

	public char pop() throws UnderFlowException {
		if (top == -1) {
			throw new UnderFlowException();
		} else {
			return array[top--];
		}
	}

	public void display() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

}
