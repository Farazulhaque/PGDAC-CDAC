package com.faraz;

public class Node {
	public Node lc;
	public int data;
	public Node rc;

	public Node(int data) {
		this.data = data;
		lc = rc = null;
	}

}