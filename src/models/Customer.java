package models;

public class Customer {
	private int id;
	private String fullName;
	private String address;
	private String phonenumber;

	public Customer() {
	}

	public Customer(int id, String fullName, String address, String phonenumber) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.phonenumber = phonenumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
