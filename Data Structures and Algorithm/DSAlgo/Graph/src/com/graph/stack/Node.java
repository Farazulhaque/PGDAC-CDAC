package com.graph.stack;

import com.graph.matrix.Edge;

public class Node {
	Edge data;
	Node link;

	public Node(Edge data) {
		this.data = data;
		link = null;
	}
}
