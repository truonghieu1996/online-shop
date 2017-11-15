package models;

public class OrderDetail {
	private int idBillInf;
	private String nameCategory;
	private String nameProduct;
	private int amount;
	private double price;
	private double totalPrice;

	public OrderDetail() {
		super();
	}

	public OrderDetail(int idBillInf, String nameCategory, String nameProduct, int amount, double price,
			double totalPrice) {
		super();
		this.idBillInf = idBillInf;
		this.nameCategory = nameCategory;
		this.nameProduct = nameProduct;
		this.amount = amount;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public int getIdBillInf() {
		return idBillInf;
	}

	public void setIdBillInf(int idBillInf) {
		this.idBillInf = idBillInf;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}