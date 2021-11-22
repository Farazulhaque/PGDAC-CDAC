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

	// Left Child | Parent | Right Child
	private void inorder(Node r) {
		if (r != null) {
			inorder(r.lc);
			System.out.print(r.data + " ");
			inorder(r.rc);
		}
	}

	// Left Child | Right Child | Parent
	private void postorder(Node r) {
		if (r != null) {
			postorder(r.lc);
			postorder(r.rc);
			System.out.print(r.data + " ");
		}
	}

	// Parent | Left Child | Right Child
	private void preorder(Node r) {
		if (r != null) {
			System.out.print(r.data + " ");
			preorder(r.lc);
			preorder(r.rc);
		}
	}

	// Right Child | Parent | Left Child
	private void reverseinorder(Node r) {
		if (r != null) {
			reverseinorder(r.rc);
			System.out.print(r.data + " ");
			reverseinorder(r.lc);
		}
	}

	private void levelbylevelorder(Node r) {
		// creating a empty queue
		SimpleQ sq = new SimpleQ();

		// adding the root node
		sq.enqueue(r);

		// sq.front != -1 is condition of empty queue
		while (sq.front != -1) {
			// removing the front node from the queue
			Node tNode = sq.dequeue();

			// print the value of the removed node
			System.out.print(tNode.data + " ");

			// if the left child is present, enqueue the left child
			if (tNode.lc != null) {
				sq.enqueue(tNode.lc);
			}

			// if the right child is present, enqueue the right child too
			if (tNode.rc != null) {
				sq.enqueue(tNode.rc);
			}
		}

	}

	public void showInorder() {
		System.out.print("\nBST in In-Order Traversal   => ");
		inorder(root);
		System.out.print("\n-----------------------------------------------------");
	}

	public void showPreorder() {
		System.out.print("\nBST in Pre-Order Traversal  => ");
		preorder(root);
		System.out.print("\n-----------------------------------------------------");
	}

	public void showPostorder() {
		System.out.print("\nBST in Post-Order Traversal => ");
		postorder(root);
		System.out.print("\n-----------------------------------------------------");
	}

	public void showBSTinDecreasingOrder() {
		System.out.print("\nBST in Decreasing Order     => ");
		reverseinorder(root);
		System.out.print("\n-----------------------------------------------------");
	}

	public void showBSTinLevelByLevelOrder() {
		System.out.print("\nBST in Level By Level Order => ");
		levelbylevelorder(root);
		System.out.print("\n-----------------------------------------------------");
	}

}