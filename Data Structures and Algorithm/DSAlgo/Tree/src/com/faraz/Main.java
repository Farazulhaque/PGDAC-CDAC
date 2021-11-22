package com.faraz;

public class Main {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(100);
		bst.insert(10);
		bst.insert(5);
		bst.insert(90);
		bst.insert(200);
		bst.insert(2);
		bst.insert(80);
		bst.insert(95);
		bst.showInorder();
		bst.showPostorder();
		bst.showPreorder();
		bst.showBSTinDecreasingOrder();
		bst.showBSTinLevelByLevelOrder();
		// bst.delete(5);
		// bst.showInorder();

	}

}