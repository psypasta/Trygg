package Cashier;

public class Product {
	private int ID;
	private String productName;
	private int price;
	
	private enum Category {
		FRUIT, VEGETABLES, DAIRY, MEAT
	}
	
	public Product(int ID, String productName, int price){
		this.ID = ID;
		this.productName = productName;
		this.price = price;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}


}


/*
Product | SubClass Fruit / Veggies / Dairy / Meat ? enums ? 
	var :
		number/ID (two digit number) : Int
		productName : String
		price : Int 
	metoder :
		getMetoder FOR ^ ?
		*/