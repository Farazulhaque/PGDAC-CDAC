package com.faraz;

public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data) {
		// (1)BST is empty
		if (root == null) {
			root = new Node(data);
			return;
		}

		// (2)BST is not empty
		Node tr = root;

		// Apply BST Rule.........
		while (true) {
			if (data <= tr.data) {
				if (tr.lc == null) {
					tr.lc = new Node(data);
					return;
				}
				tr = tr.lc;
			} else {
				if (tr.rc == null) {
					tr.rc = new Node(data);
					return;
				}
				tr = tr.rc;
			}
		}
	}

	private void inorder(Node r) {

		if (r != null) {
			inorder(r.lc);
			System.out.print(r.data + " ");
			inorder(r.rc);
		}
	}

	public void show() {
		System.out.println("\nBST => ");
		inorder(root);
	}

	public void delete(int data) {
		// (1)BST is empty
		if (root == null) {
			System.out.println("BST Empty.....");
			return;
		}

		// (2)BST is not empty
		Node tr = root;
		Node p = null;
		while (tr != null) {
			if (data == tr.data) {
				doDeletion(p, tr); // data found. Do deletion
				return;
			}
			p = tr;
			tr = (data < tr.data) ? tr.lc : tr.rc; // Traverse using BST Rule.........
		}
		System.out.println("Data not found in BST.....");
	}

	private void doDeletion(Node p, Node tr) {
		// (1) Node to be removed has only 'LC'
		if (tr.lc != null && tr.rc == null) {
			if (p == null) // (I) Node to be removed ('tr') is 'ROOT'
			{
				root = tr.lc;
				tr.lc = null;
			} else if (p.lc == tr) // (II) Node to be removed ('tr') is 'LC' of its parent ('p')
			{
				p.lc = tr.lc;
			} else // (III) Node to be removed ('tr') is 'RC' of its parent ('p')
			{
				p.rc = tr.lc;
			}
			return;
		}

		// (2) Node to be removed has only 'RC'
		if (tr.lc == null && tr.rc != null) {
			if (p == null) // (I) Node to be removed ('tr') is 'ROOT'
			{
				root = tr.rc;
				tr.rc = null;
			} else if (p.lc == tr) // (II) Node to be removed ('tr') is 'LC' of its parent ('p')
			{
				p.lc = tr.rc;
			} else // (III) Node to be removed ('tr') is 'RC' of its parent ('p')
			{
				p.rc = tr.rc;
			}
			return;
		}

	}

}