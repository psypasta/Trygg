package registerSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class Receipt {
	
	private static final double MOMS = 0.25;
	private static final String COMPANY = "ICA Nära";;
	private static final int ORGNUMBER = 4201337;;
	
	private static int ID;
	
	private List <Product> productList = new ArrayList<Product>();
	private String data;
	
	public Receipt() {
		data =	"KVITTENS\n\nCompany: " + COMPANY + "\n" 
				+ "Org#: " + ORGNUMBER + "\n";
	}
	
	public void addLine(Product p) {
		data += p.getID() + " " + p.getProductName() + " " + p.getPrice() + "kr\n";
	}
	
	public String print() {
		//System.out.println(date.getTime());
		
		data += "\nDate: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		
		return data;

	}
	
	public String getData() {
		return data;
	}

}
