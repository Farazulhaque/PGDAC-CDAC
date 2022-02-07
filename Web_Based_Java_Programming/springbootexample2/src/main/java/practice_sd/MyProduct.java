package practice_sd;

public class MyProduct {
	private int mpid;
	private String mproductName;
	private MyProductInventory minv;

	public int getMpid() {
		return mpid;
	}

	public void setMpid(int mpid) {
		this.mpid = mpid;
	}

	public String getMproductName() {
		return mproductName;
	}

	public void setMproductName(String mproductName) {
		this.mproductName = mproductName;
	}

	public MyProductInventory getMyinv() {
		return minv;
	}

	public void setMinv(MyProductInventory minv) {
		this.minv = minv;
	}

	public void productInfo() {
		System.out.println(minv.toString());
	}

}
