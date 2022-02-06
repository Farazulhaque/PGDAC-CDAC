package practice;

public class Sales {
	private int salesId;
	private String salesName;
	private Product product;

	public Sales() {

	}

	public Sales(int salesId, String salesName) {
		this.salesId = salesId;
		this.salesName = salesName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public void show() {
		System.out.println("hello sales");
		System.out.println(product.toString());
	}
}
