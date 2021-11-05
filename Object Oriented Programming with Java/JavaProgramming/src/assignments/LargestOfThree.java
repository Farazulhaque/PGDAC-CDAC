package assignments;

import java.util.Scanner;

public class LargestOfThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.print("Enter First Number: ");
			int num1 = sc.nextInt();
			System.out.print("Enter Second Number: ");
			int num2 = sc.nextInt();
			System.out.print("Enter Third Number: ");
			int num3 = sc.nextInt();

			if (num1 > num2 && num1 > num3) {
				System.out.println(num1 + " is Largest.");
			} else if (num2 > num1 && num2 > num3) {
				System.out.println(num2 + " is Largest.");
			} else if (num3 > num1 && num3 > num2) {
				System.out.println(num3 + " is Largest.");
			} else {
				System.out.println("All three numbers are equal.");
			}

			System.out.print("\nDo you want to enter again? (Y/n): ");
			String again = sc.next();
			if (again.equalsIgnoreCase("n")) {
				loop = false;
			}
		}
		sc.close();
	}
}
