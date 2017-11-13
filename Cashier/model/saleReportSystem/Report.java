package model.saleReportSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.adminSystem.User;
import model.registerSystem.Product;

public class Report {

	private List<Product> productList = new ArrayList<Product>();
	private String date;
//	private int soldProducts;
//	private List<User> userList = new ArrayList<User>();
	private String reportName = "rapport" ;
	private static int reportCount = 0;
	private String data;
	
	public Report(List productList) {
		this.productList = productList;
		date = "\nDate: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	
	public String reportName() {
		reportName += reportCount;
		reportCount++;
		return reportName;
	}
	
	//Skriva ut en rapport till en fil!
	public String printReport() {
		//data - > fil
		data = date + "\n" + "Sum: " + "\n";
		
		for(int i = 0; i < productList.size(); i++) {
			data += "Product\n\tID: " + productList.get(i).getID() + "\n\tName: " + productList.get(i).getProductName()
				+ "\n\tPrice" + productList.get(i).getPrice() + "\n\tßCategory: " + productList.get(i).getSort() + "\n\n";
		}
	//	System.out.println(data);
		return data;
	}
	
	
}
