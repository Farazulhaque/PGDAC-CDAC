package assignments;

import java.util.Scanner;

public class ElectricityBill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, a, amt1, amt2, amt3, amt4;

		System.out.println("1. For 1-100 units");
		System.out.println("2. For 101-200 units");
		System.out.println("3. For 201-500 units");
		System.out.println("4. For 501 onward units");
		System.out.println("5. For exit");

		System.out.println("Enter your choice:");
		n = sc.nextInt();
		System.out.println("Enter your electricity units: ");
		a = sc.nextInt();

		switch (n) {
		case 1:
			amt1 = a * 6;
			System.out.println("The amount of electricity bill: " + amt1);
			break;
		case 2:
			amt2 = a * 7;
			System.out.println("The amount of electricity bill: " + amt2);
			break;
		case 3:
			amt3 = a * 8;
			System.out.println("The amount of electricity bill: " + amt3);
			break;
		case 4:
			amt4 = a * 9;
			System.out.println("The amount of electricity bill: " + amt4);
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option");
		}
		sc.close();
	}

}
