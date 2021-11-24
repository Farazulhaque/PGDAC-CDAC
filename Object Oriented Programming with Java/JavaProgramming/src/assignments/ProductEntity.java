package assignments;

class Product {
    int productId;
    String productName;
    float productPrice;

    public Product() {
        this.productId = (int) (Math.random() * (9999 - 1111 + 1) + 1111);
        // To generate 4 digit random number
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void display() {
        System.out.printf("%-15s: %s\n", "Product ID", productId);
        System.out.printf("%-15s: %s\n", "Product Name", productName);
        System.out.printf("%-15s: %s\n", "Product Price", productPrice);
    }

    public void accept(String productName, float productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public void displayAllProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%-15s: %s\n", "Product ID", products[i].getProductId());
            System.out.printf("%-15s: %s\n", "Product Name", products[i].getProductName());
            System.out.printf("%-15s: %s\n", "Product Price", products[i].getProductPrice());
            System.out.println();
        }
    }
}

public class ProductEntity {
    public static void main(String[] args) {
        Product[] p;
        p = new Product[4];
        for (int i = 0; i < 4; i++) {
            p[i] = new Product();
        }
        p[0].accept("Sugar", 50);
        p[1].accept("Salt", 20);
        p[2].accept("Rice", 40);
        p[3].accept("Oil", 80);
        Product obj = new Product();
        obj.displayAllProducts(p);
    }
}