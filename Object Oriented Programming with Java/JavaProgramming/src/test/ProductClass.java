//Implement Comparable interface for Product class and write a program to accept products in an array of Product type
//and display all accepted products in the ascending order of their prices. The Product class fields are - Product code,
//name and price.  

package test;

import java.util.ArrayList;
import java.util.Comparator;

class PrizeComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        if (p1.product_price > p2.product_price) {
            return 1;
        } else if (p1.product_price < p2.product_price) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Product {
    int product_code;
    String product_name;
    double product_price;

    public Product(int product_code, String product_name, double product_price) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public String toString() {
        // System.out.println()
        String p_code = String.valueOf(product_code);
        String p_price = String.valueOf(product_price);
        product_name = String.format("%-15s", product_name);
        p_code = String.format("%-15s", p_code);
        p_price = String.format("%15s", p_price);
        return p_code + "" + product_name + "" + p_price;
    }

}

public class ProductClass {

    public static void addProductsToArray(ArrayList<Product> list) {
        // int product_code;
        // String product_name;
        // double product_price;
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter Product Code: ");
        // product_code = sc.nextInt();
        // System.out.print("Enter Product Name: ");
        // sc.nextLine();
        // product_name = sc.nextLine();
        // System.out.print("Enter Product Price: ");
        // product_price = sc.nextDouble();

        list.add(new Product(101, "Soap", 30.0));
        list.add(new Product(201, "Surf", 60.0));
        list.add(new Product(111, "Dettol", 50.0));
        list.add(new Product(211, "Biscuit", 35.0));
        list.add(new Product(109, "lays", 10.0));
        // sc.close();

    }

    public static void sortProductsByPrice(ArrayList<Product> list) {
        list.sort(new PrizeComparator());
    }

    public static void display(ArrayList<Product> list) {
        System.out.printf("\n%-15s%-15s%15s\n", "Product Code", "Product Name", "Product Price");
        System.out.println("----------------------------------------------");
        for (Product p : list) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> p = new ArrayList<Product>();
        ProductClass.addProductsToArray(p);
        // ProductClass.addProductsToArray(p);
        // ProductClass.addProductsToArray(p);
        // ProductClass.addProductsToArray(p);
        // ProductClass.addProductsToArray(p);
        ProductClass.display(p);
        ProductClass.sortProductsByPrice(p);
        System.out.print("\n====================Sorted====================");
        ProductClass.display(p);
    }
}
