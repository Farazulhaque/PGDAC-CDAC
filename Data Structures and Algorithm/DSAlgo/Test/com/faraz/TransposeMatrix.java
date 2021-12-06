package com.faraz;

import java.util.Scanner;

public class TransposeMatrix {
	// initialise variables to store data
	int r, c;
	int[][] matrix;
	int[][] transposedMatrix;
	Scanner sc = new Scanner(System.in);

	// get row and column size on object creation
	public TransposeMatrix() {
		System.out.println("Enter row size: ");
		r = sc.nextInt();

		System.out.println("Enter column size: ");
		c = sc.nextInt();
		// create two matrix, one for original matrix and one for transposed matrix
		matrix = new int[r][c];
		transposedMatrix = new int[r][c];
	}

	// method to insert item in the matrix
	public void insertdata() {
		// nested loop to get user input data
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print("matrix[" + i + "][" + j + "] = ");
				matrix[i][j] = sc.nextInt();
			}
		}
	}

	// method to transpose matrix
	public void findTranspose() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				// swap i with j and j with i to get transposed data
				transposedMatrix[j][i] = matrix[i][j];
			}
		}
	}

	// method to show original matrix
	public void showOriginalMatrix() {
		System.out.println("\n-----------Original Matrix-----------");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// method to show transposed matrix
	public void showTransposedMatrix() {
		System.out.println("\n-----------Transposed Matrix-----------");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(transposedMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
