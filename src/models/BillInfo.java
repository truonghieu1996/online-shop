package models;

public class BillInfo {
	private int id;
	private int idBill;
	private int idProduct;
	private int amount;

	public BillInfo() {
	}

	public BillInfo(int id, int idBill, int idProduct, int amount) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.idProduct = idProduct;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
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
