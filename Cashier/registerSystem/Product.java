package registerSystem;


public class Product {
	
	
	private int nType;
	private int inventory;
	private String ID;
	private String productName;
	private double price;
	private String sort;
	
	private static int IDCount;
	
	public Product() {
		
	}

	//Category cName;
	

	public Product(String ID, String productName, double price, String sort){

		this.ID = ID;
		this.productName = productName;
		this.price = price;

		IDCount++;

		this.sort = sort;
	}
	
	
	
	public String getID() {
		return ID;
	}
	
	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}
	
	public String getSort() {
		return sort;
	}


}


