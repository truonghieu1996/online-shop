package models;

import java.util.Date;

public class Order {
	private int idCustomer;
	private int idBill;
	private int idBillInf;
	private String fullName;
	private String address;
	private String phonenumber;
	private Date checkIn;
	private Date checkOut;
	private int pamentMethod;
	private int status;
	private int idProduct;
	private int amount;

	public Order() {
	}

	public Order(String fullName, String address, String phonenumber, Date checkIn, Date checkOut, int pamentMethod,
			int status, int idCustomer, int idBill, int idBillInf, int idProduct, int amount) {
		this.fullName = fullName;
		this.address = address;
		this.phonenumber = phonenumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.pamentMethod = pamentMethod;
		this.status = status;
		this.idCustomer = idCustomer;
		this.idBill = idBill;
		this.idBillInf = idBillInf;
		this.idProduct = idProduct;
		this.amount = amount;
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

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date chekIn) {
		this.checkIn = chekIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public int getPamentMethod() {
		return pamentMethod;
	}

	public void setPamentMethod(int pamentMethod) {
		this.pamentMethod = pamentMethod;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public int getIdBillInf() {
		return idBillInf;
	}

	public void setIdBillInf(int idBillInf) {
		this.idBillInf = idBillInf;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
