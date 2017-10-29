package models;

public class StatisticalCategory {
	private String nameCategory;
	private int value;

	public StatisticalCategory() {
	}

	public StatisticalCategory(String nameCategory, int value) {
		super();
		this.nameCategory = nameCategory;
		this.value = value;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
