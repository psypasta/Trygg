package registerSystem;


public class Product {
	
	
	private int nType;
	private int inventory;
	private int ID;
	private String productName;
	private double price;
	private Category sort;
	
	private static int IDCount;

	public enum Category {MEAT, DAIRY, VEGETABLE, FRUIT}; //Categories for the products. Coding tradition has it that they are supposed to be in all caps, which can cause problems with our textfile since it also has to be in all caps. Suggestions for it not to look weird in GUI? - J.V
	
	public Product() {
		
	}

	Category cName;
	

	public Product(int ID, String productName, double price, Category sort){

		this.ID = ID;
		this.productName = productName;
		this.price = price;

		IDCount++;

		this.sort = sort;
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
	
	public Category getSort() {
		return sort;
	}


}


