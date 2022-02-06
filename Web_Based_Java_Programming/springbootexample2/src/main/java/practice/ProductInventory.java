package practice;

public class ProductInventory {

	private int invId;
	private int quantity;
	private String color;

	public ProductInventory() {

	}

	public ProductInventory(int invId, int quantity, String color) {
		super();
		this.invId = invId;
		this.quantity = quantity;
		this.color = color;
	}

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ProductInventory [invId=" + invId + ", quantity=" + quantity + ", color=" + color + "]";
	}
}
