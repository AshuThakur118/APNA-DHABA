package com.ashutosh.bean;

public class Menu {
	private String itemName;
	private Double itemPrice;
	
	public Menu() {}

	public Menu(String itemName, Double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Menu [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
}