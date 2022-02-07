package practice_sd;

import java.util.Map;

public class MyProductInventory {
	private int invid;
	private int quantity;
	private Map<MyProduct, Lead> item;

	public int getInvid() {
		return invid;
	}

	public void setInvid(int invid) {
		this.invid = invid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Map<MyProduct, Lead> getItem() {
		return item;
	}

	public void setItem(Map<MyProduct, Lead> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "MyProductInventory [invid=" + invid + ", quantity=" + quantity + "]";
	}

}
