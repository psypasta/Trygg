package registerSystem;


public class Product {
	/*
	private static enum Category {
		FRUIT, VEGETABLES, DAIRY, MEAT, NULL
	}
	
	// ^ v - publics?? confoos
	
	private static final int FRUIT = 0;
	private static final int VEGETABLES = 1;
	private static final int DAIRY = 2;
	private static final int MEAT = 3;
	
	private Category category;
	*/
	
	private int ID;
	private static int IDcount;
	private int inventory;
	private String productName;
	private double price;
	
	//private Product p2 = new Product();                   //What purpose does these have? Right now all they seem to do is crash the program. - J.V
	//private Product p = new Product(ID, productName, price);
	
	public Product() {
		
	}
	
	public Product(int ID, String productName, double price){
		this.ID = ID;
		this.productName = productName;
		this.price = price;
		IDcount++;
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


/*
Product | SubClass Fruit / Veggies / Dairy / Meat ? enums ? 
	var :
		number/ID (two digit number) : Int
		productName : String
		price : Int 
	metoder :
		getMetoder FOR ^ ?
		*/