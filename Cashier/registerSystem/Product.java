package registerSystem;


public class Product {
	
	private int ID;
	private int nType;
	private int inventory;
	private String productName;
	private double price;
	
	private static int objectCount;

	public enum Category {
		MEAT, DAIRY, FRUIT, VEGETABLES,
	}
	
	Category cName;
	
	public Product(int ID, String productName, double price){
		this.ID = ID;
		this.productName = productName;
		this.price = price;
		objectCount++;
	}
	
	
	
	public int getID() {
		return ID;
	}
	
	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}


}


