package saleReportSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adminSystem.User;

public class Report {

	private String productName;
	private String date;
	private int soldProducts;
	private double totalSum;
	List<User> userList = new ArrayList<User>();
	
	private String data;
	
	public Report() {
		date = "\nDate: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	
	//Skriva ut en rapport till en fil!
	public void printReport() {
		//data - > fil
	}
	
	
}
