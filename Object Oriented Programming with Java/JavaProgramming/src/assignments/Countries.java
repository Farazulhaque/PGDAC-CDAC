package assignments;

import java.util.Scanner;

public class Countries {
    public static void main(String[] args) {
        String[] countriesName = new String[5];
        int[][] medals = new int[5][3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < countriesName.length; i++) {
            System.out.print("Enter country name: ");
            countriesName[i] = sc.next();
            System.out.print("Enter number of golds won: ");
            medals[i][0] = sc.nextInt();
            System.out.print("Enter number of silver won: ");
            medals[i][1] = sc.nextInt();
            System.out.print("Enter number of bronze won: ");
            medals[i][2] = sc.nextInt();
        }
        System.out.printf("\n%-15s %10s %10s %10s", "Country Name", "Gold", "Silver", "Bronze");
        for (int i = 0; i < countriesName.length; i++) {
            System.out.printf("\n%-15s %10s %10s %10s", countriesName[i], medals[i][0], medals[i][1], medals[i][2]);
        }
        sc.close();
    }
}