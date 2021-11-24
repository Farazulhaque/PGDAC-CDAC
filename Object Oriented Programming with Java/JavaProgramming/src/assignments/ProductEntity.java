package assignments;

class Product {
    int productId;
    String productName;
    float productPrice;

    public Product(int productId, String productName, float productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductID() {
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
        Product p = new Product(1505, "Sugar", 50);
        p.display();
    }
}