package com.graph.disjoint;

public class SetNode {
	public ItemNode data;
	public SetNode link;

	public SetNode(ItemNode data) {
		this.data = data;
		link = null;
	}
}