package practice_cd;

import java.util.List;

public class Customer {
	private int cid;
	private String customerName;
	private List<CustomerAddress> customerAddress;

	public Customer(int cid, String customerName, List<CustomerAddress> customerAddress) {
		this.cid = cid;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void details() {
		System.out.println("Customer Name is: " + customerName);
		System.out.println("Customer Address is: ");
		for (CustomerAddress add : customerAddress) {
			System.out.println(add.getAddress());
		}
	}
}
