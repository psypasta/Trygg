package registerSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adminSystem.User;
public class Receipt {
	
	private static final double MOMS = 0.25;
	private static final String COMPANY = "ICA Nära";;
	private static final int ORGNUMBER = 4201337;;
	
	private static int ID;
	
	private List <Product> productList = new ArrayList<Product>();
	private String data;
	private double sum = 0;
	
	public Receipt(User u) {
		data =	"KVITTENS\n\nCompany: " + COMPANY + "\n" 
				+ "Org#: " + ORGNUMBER + "\nKassör: " + u.getCredentials().getUserName() + " " + u.getFirstName()+ "\n\n";
	}
	
	public void addLine(Product p) {
		data += p.getID() + " " + p.getProductName() + " " + p.getPrice() + "kr\n";
		sum += p.getPrice();
	}
	
	public String print() {
		data += "\nSum: " + sum + "\nDate: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		data += "\n";
		
		return data;
	}
	
/*	public String getData() {
		// TODO Auto-generated method stub
		return data;
	}
*/

}
