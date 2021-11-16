package com.faraz;

public class Addition {
    // create three dll
    // first and second dll to store each number to separate nodes
    DLL dll1 = new DLL();
    DLL dll2 = new DLL();
    // and third to store sum of two numbers
    DLL dll3 = new DLL();

    public void addNumbers(String num1, String num2) {

        // loop to add each character to separate nodes of dll1
        for (int i = 0; i < num1.length(); i++) {
            // first get character at ith index, then convert character to string
            // and then convert that string to integer datatype
            dll1.append(Integer.parseInt(Character.toString(num1.charAt(i))));
        }

        // loop to add each character to separate nodes of dll2
        for (int i = 0; i < num2.length(); i++) {
            // first get character at ith index, then convert character to string
            // and then convert that string to integer datatype
            dll2.append(Integer.parseInt(Character.toString(num2.charAt(i))));
        }

        // dll1.show();
        // dll2.show();

        // set carry to 0 so that we can add carry to sum on each iteration
        int carry = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        // store max length from num1 and num2
        // because we want to add that much nodes to dll3
        int n = (l1 > l2 ? l1 : l2);
        for (int i = 0; i <= n; i++) {
            // get last number from dll1 and dll2
            // since addtion works from right to left
            int digit1 = dll1.getLastNumber();
            int digit2 = dll2.getLastNumber();
            int sum = digit1 + digit2 + carry;
            // store carry
            if (sum >= 10) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            // and then add at begin sum modulo 10
            // because modulo gives remainder
            dll3.addAtBegin(sum % 10);

        }
        System.out.print(num1);
        System.out.print(" + ");
        System.out.print(num2);
        System.out.print(" = ");
        dll3.show();
    }
}
