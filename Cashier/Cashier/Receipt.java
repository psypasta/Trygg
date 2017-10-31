package Cashier;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	
	private static final double MOMS = 0.25;
	private int ID;
	
	private String CompanyName;
	private int Orgnumber;
	private String date;
	private List <Product> productList = new ArrayList<Product>();

	public Receipt(List productList) {
		this.productList = productList;
	}
	
	public void print() {
		
	}
	
}
