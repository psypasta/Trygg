package Cashier;

import java.util.ArrayList;
import java.util.List;

public class Register {
	
	//product count
	private int productCount;
	private List <Product> productList = new ArrayList<Product>();
	private Receipt kvitto = new Receipt(productList);
	
	
	
	public double weigh() {
		return 0;
	}
}
