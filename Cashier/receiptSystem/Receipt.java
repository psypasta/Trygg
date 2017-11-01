package receiptSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import registerSystem.Product;
import java.util.Date;
public class Receipt {
	
	private static final double MOMS = 0.25;
	private int ID;
	
	private String CompanyName;
	private int Orgnumber;
	private String Date;
	private List <Product> productList = new ArrayList<Product>();
	
	public Receipt(List productList) {
		this.productList = productList;
		CompanyName = "test";
		Orgnumber = 1337;
		
	}
	
	public void print() {
		
	}
	public class GetCurrentDateTime
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		
		
	}
}
