package com.fa.poly;

import com.fa.sll.Node;
import com.fa.sll.SLL;

public class PolynomialEquation {
	private SLL s1;

	public PolynomialEquation() {
		s1 = new SLL();
	}

	public void addPolyTerm(PolyTerm t) {
		s1.append(t);
	}

	public void showEquation() {
		PolyTerm d;
		for (Node tr = s1.head; tr != null; tr = tr.link) {
			d = tr.data;
			String ps = (d.coef > 0) ? "+" : "";
			if (d.var.equals("")) {
				System.out.print(ps + "" + d.coef + "");
			} else if (d.exp == 1) {
				System.out.print(ps + "" + d.coef + "" + d.var + "");
			} else {
				System.out.print(ps + "" + d.coef + "" + d.var + "" + d.exp);
			}
		}
		System.out.println();
	}

	public PolynomialEquation addEquation(PolynomialEquation e2) {
		PolynomialEquation e3 = new PolynomialEquation();
		PolyTerm et1, et2;
		Node tr1 = s1.head;
		Node tr2 = e2.s1.head;

		while (tr1 != null && tr2 != null) {
			et1 = tr1.data;
			et2 = tr2.data;

			// add similar term of both equation.............
			if (et1.var.equals(et2.var) && et1.exp == et2.exp) {
				e3.addPolyTerm(new PolyTerm(et1.coef + et2.coef, et1.var, et2.exp));
				tr1 = tr1.link;
				tr2 = tr2.link;
			} else if (et1.var.equals(et2.var) && et1.exp > et2.exp) {
				e3.addPolyTerm(new PolyTerm(et1));
				tr1 = tr1.link;
			} else if (et1.var.equals(et2.var) && et1.exp < et2.exp) {
				e3.addPolyTerm(new PolyTerm(et2));
				tr2 = tr2.link;
			}
		}

		// takes care of left over terms of either equation...
		while (tr1 != null) {
			e3.addPolyTerm(new PolyTerm(tr1.data));
		}
		while (tr2 != null) {
			e3.addPolyTerm(new PolyTerm(tr2.data));
		}

		return e3;
	}
	/*
	 * public void getEquation() { Scanner sc = new Scanner(System.in);
	 * System.out.println("Enter equation: "); String eq = sc.nextLine(); // convert
	 * array of characters char[] arr = eq.toCharArray();
	 * 
	 * // 10X4 - 20X2 - 30 + 8X
	 * 
	 * // read the entire equation and remove all the blanks...
	 * 
	 * // coef.... // while (we get numeric character){ // }
	 * 
	 * // var... // while (we get alphabetic character){ // }
	 * 
	 * // exp... // while(we get numeric character){ // }
	 * 
	 * // for (int i = 0; i < arr.length; i++) { // // }
	 * 
	 * System.out.println(eq); }
	 */
}
