package com.fa;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		MyStack s = new MyStack();
		// int item;
		// try {
		// s.push(10);
		// s.push(20);
		// item = s.pop();
		// System.out.println("Popped item = " + item);
		// item = s.pop();
		// System.out.println("Popped item = " + item);
		// item = s.pop();
		// System.out.println("Popped item = " + item);
		// System.out.println("Success");
		// } catch (OverFlowException | UnderFlowException e) {
		// System.out.println(e);
		// } finally {
		// System.out.println("OVER");
		// }
		//
		// Reverse a string using stack
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = sc.nextLine();
		char[] ch = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		try {
			for (int i = 0; i < ch.length; i++) {
				s.push(ch[i]);
			}
			for (int i = 0; i < str.length(); i++) {
				ch[i] = s.pop();
			}

		} catch (OverFlowException | UnderFlowException e) {
			System.out.println(e);
		} finally {
			str = new String(ch);
			System.out.println(str);
		}
		sc.close();
	}
}
