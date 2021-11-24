package assignments;

class Product2 implements Cloneable {
    String productname;
    float productprice;

    public Product2(String productname, float productprice) {
        this.productname = productname;
        this.productprice = productprice;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product2 p1 = new Product2("Sugar", 50);

        System.out.println("Original: ");
        System.out.println("Product Name: " + p1.productname);
        System.out.println("Product price: " + p1.productprice);
        System.out.println("----------------------");
        Product2 p12 = (Product2) p1.clone();
        System.out.println("Cloned: ");
        System.out.println("Product Name: " + p12.productname);
        System.out.println("Product price: " + p12.productprice);
        System.out.println("-------------------------------------");

        p12.productprice = 25;
        System.out.println("After updating price in clone object:");
        System.out.println("-------------------------------------");
        System.out.println("Original: ");
        System.out.println("Product Name: " + p1.productname);
        System.out.println("Product price: " + p1.productprice);
        System.out.println("----------------------");
        System.out.println("Cloned: ");
        System.out.println("Product Name: " + p12.productname);
        System.out.println("Product price: " + p12.productprice);

    }
}
