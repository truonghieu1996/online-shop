package models;

public class Product {
	private int id;
	private int idCategory;
	private String name;
	private double price;
	private String description;
	private String image;
	private int amount;

	public Product() {
	}

	public Product(int id, int idCategory, String name, double price, String description, String image,
			int amount) {
		super();
		this.id = id;
		this.idCategory = idCategory;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
