package com.faraz;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter First Number: ");
		String num1 = sc.next();
		System.out.print("Enter Second Number: ");
		String num2 = sc.next();
		sc.close();

		Addition ad = new Addition();
		ad.addNumbers(num1, num2);
	}

}
