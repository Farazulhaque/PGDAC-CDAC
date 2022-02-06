package practice;

public class Product {

	private int productId;
	private String productName;
	private String productCompany;
	private ProductInventory productInventory;

	public Product() {

	}

	public Product(int productId, String productName, String productCompany, ProductInventory productInventory) {
		this.productId = productId;
		this.productName = productName;
		this.productCompany = productCompany;
		this.productInventory = productInventory;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCompany=" + productCompany
				+ ", productInventory=" + productInventory + "]";
	}
}
