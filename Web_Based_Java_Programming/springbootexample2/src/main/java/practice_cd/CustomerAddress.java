package practice_cd;

public class CustomerAddress {
	private int addressId;
	private String address;
	private int pincode;

	public CustomerAddress() {

	}

	public CustomerAddress(int addressId, String address, int pincode) {
		this.addressId = addressId;
		this.address = address;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public String getAddress() {
		return address;
	}

	public int getPincode() {
		return pincode;
	}

}
