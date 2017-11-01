package receiptSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import registerSystem.Product;
public class Receipt {
	
	private static final double MOMS = 0.25;
	private static final String COMPANY = "ICA Nära";;
	private static final int ORGNUMBER = 4201337;;
	
	private static int ID;
	
	private Date date;
	private String sDate;
	
	private List <Product> productList = new ArrayList<Product>();
	private String data;
	
	public Receipt(List productList) {
		this.productList = productList;

		data = "Products: " + productList + "\n"
				+ "Company: " + COMPANY + "\n" 
				+ "Org#: " + ORGNUMBER;
		
		System.out.println(data);
		
	}
	
	public void print() {
		System.out.println(date.getTime());
		//System.out.println(date.get());
	//	System.out.println(date.getTime());
		//System.out.println(date.getTime());

	}
	
	public class GetCurrentDateTime
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
	//	DateFormat.Field
		
		
	}
}
