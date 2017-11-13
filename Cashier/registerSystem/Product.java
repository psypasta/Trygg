package registerSystem;


public class Product {
	
	//Product class fields.
	private int nType;
	private int inventory; //Maybe use this?
	//Fields for product
	private String ID;
	private String productName;
	private double price;
	private String sort;
	private WeightUnit weightUnit;
	
	private static int IDCount;
	
	enum WeightUnit {UNIT, WEIGHT}
	
	//Empty unused constructor I think?
	public Product() {
		
	}

	//Actual constructor sets the objects fields to whats incoming
	public Product(String ID, String productName, double price, String sort){

		this.ID = ID;
		this.productName = productName;
		this.price = price;

		IDCount++;

		this.sort = sort;
		if (this.sort.equals("FRUIT") || this.sort.equals("VEGETABLE")) //Mostly testing to see how the program should see if a product
			                                                            //should be measured in unit or weight. Has of now no real function
		{
			this.weightUnit = Product.WeightUnit.WEIGHT;
		}
		else
		{
			this.weightUnit = Product.WeightUnit.UNIT;
		}
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

    public WeightUnit getWeightUnit() {
    	return weightUnit;
    	
    }
}

