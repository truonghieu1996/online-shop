package models;

public class ProductTeam {

	private int id;
	private String nameCategory;
	private String name;
	private double price;
	private String description;
	private String image;
	private int amount;
	
	
	public ProductTeam() {
	}

	public ProductTeam(int id, String nameCategory, String name, double price, String description, String image,
			int amount) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
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

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
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
