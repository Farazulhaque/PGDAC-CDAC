package assignments;

import java.util.Scanner;

class Draw {
    public void print(int rows) {
        int temp = 1;
        for (int i = 1; i <= rows; i++) {
            // beginning space
            for (int l = rows; l > i; l--) {
                System.out.print(" ");
            }
            // so that starting number of each row is row number
            if (i >= 3) {
                temp = i;
            }
            // print half-side
            for (int j = 1; j <= i; j++) {
                System.out.print(temp + " ");
                temp++;
            }
            // print other side
            int temp1 = temp - 1;
            for (int k = 2; k <= i; k++) {
                System.out.print(--temp1 + " ");
            }
            // new line on each iteration
            System.out.println();
        }
    }
}

public class Pattern {
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner sc = new Scanner(System.in);
        // Get the number of rows from the user
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        sc.close();
        // using parameterized constructor
        Draw d = new Draw();
        d.print(rows);
    }
}
