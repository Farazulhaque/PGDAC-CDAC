package assignments;

import java.util.*;

class Product1 implements Comparable<Product1> {
    String productname;
    float productprice;

    public Product1(String productname, float productprice) {
        this.productname = productname;
        this.productprice = productprice;
    }

    @Override
    public int compareTo(Product1 o) {
        if (this.productprice == o.productprice)
            return 0;
        else if (this.productprice > o.productprice)
            return 1;
        return -1;
    }

}

public class ComparableInterface {
    public static void main(String[] args) {
        Product1 p1 = new Product1("Sugar", 50);
        Product1 p2 = new Product1("Salt", 20);
        Product1 p3 = new Product1("Rice", 40);
        Product1 p4 = new Product1("Oil", 80);

        ArrayList<Product1> arr = new ArrayList<Product1>();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);

        for (Product1 p : arr) {
            System.out.println(p.productname + " " + p.productprice);
        }

        Collections.sort(arr);
        System.out.println("\n----------------\n");
        for (Product1 p : arr) {
            System.out.println(p.productname + " " + p.productprice);
        }
    }
}
