package models;

import java.util.Date;

class Bill {
	private int id;
	private int idCustomer;
	private int method;
	private Date chekin;
	private Date checkout;
	private int status;
	private double totalPrice;

	public Bill() {
	}

	public Bill(int id, int idCustomer, int method, Date chekin, Date checkout, int status, double totalPrice) {
		super();
		this.id = id;
		this.idCustomer = idCustomer;
		this.method = method;
		this.chekin = chekin;
		this.checkout = checkout;
		this.status = status;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

	public Date getChekin() {
		return chekin;
	}

	public void setChekin(Date chekin) {
		this.chekin = chekin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
