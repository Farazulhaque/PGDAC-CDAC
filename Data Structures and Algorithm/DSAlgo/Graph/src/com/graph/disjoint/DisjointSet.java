package com.graph.disjoint;

public class DisjointSet {
	SetNode head = null;

	public void addToSet(ItemNode data) {
		if (head == null) {
			head = new SetNode(data);
		}
		SetNode t = new SetNode(data);
		t.link = head;
		head = t;
	}

	public ItemNode getTheSet(int i) {
		SetNode p = null;
		SetNode tr = head;
		while (true) { // traverse in vertical
			ItemNode ti = tr.data;
			ItemNode setChain = tr.data;
			while (ti != null) { // traverse in horizontal
				if (ti.data == i) {
					if (p == null) {
						head = head.link;
					} else {
						p.link = tr.link;
					}
					return setChain;
				}
				ti = ti.link;
			} // end of traverse in horizontal
			p = tr;
			tr = tr.link;
		}
	}
}