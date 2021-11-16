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
		bst.show();

		bst.delete(5);
		bst.show();

		System.out.println("\nTree ends...........");
	}

}