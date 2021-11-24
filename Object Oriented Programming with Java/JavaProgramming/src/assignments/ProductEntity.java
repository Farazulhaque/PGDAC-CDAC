package assignments;

class Product {
    int productId;
    String productName;
    float productPrice;

    public Product(String productName, float productPrice) {
        this.productId = (int) (Math.random() * (9999 - 1111 + 1) + 1111);
        // To generate 4 digit random number
        this.productName = productName;
        this.productPrice = productPrice;
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
}

public class ProductEntity {
    public static void main(String[] args) {
        Product p = new Product("Sugar", 50);
        p.display();
    }
}