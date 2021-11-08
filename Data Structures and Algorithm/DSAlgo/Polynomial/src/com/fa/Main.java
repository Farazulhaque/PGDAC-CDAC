package com.fa;

import com.fa.poly.PolyTerm;
import com.fa.poly.PolynomialEquation;

public class Main {

	public static void main(String[] args) {

		PolynomialEquation e1 = new PolynomialEquation();

		// 10x^4 - 20x^2 + 8x - 30
		e1.addPolyTerm(new PolyTerm(10, "X", 4));
		e1.addPolyTerm(new PolyTerm(-20, "X", 2));
		e1.addPolyTerm(new PolyTerm(8, "X"));
		e1.addPolyTerm(new PolyTerm(-30));
		System.out.print("Equation 1 ==>  ");
		e1.showEquation();

		PolynomialEquation e2 = new PolynomialEquation();

		// 5x^4 - 3x - 10
		e2.addPolyTerm(new PolyTerm(5, "X", 4));
		e2.addPolyTerm(new PolyTerm(-3, "X"));
		e2.addPolyTerm(new PolyTerm(-10));

		System.out.print("Equation 2 ==>  ");
		e2.showEquation();

		PolynomialEquation e3 = e1.addEquation(e2); // e3 = e1 + e2
		// System.out.println("\nAfter adding Equation1 and Equation2");
		System.out.println("--------------------------------");
		System.out.print("Equation 3 ==>  ");
		e3.showEquation();

		/*
		 * PolynomialEquation e1 = new PolynomialEquation(); e1.getEquation();
		 */
		// System.out.println("End of our program");
		System.out.println();
	}

}
