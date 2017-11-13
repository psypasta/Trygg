package saleReportSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.FileHandler;
import registerSystem.Payment;
import registerSystem.Product;

public class Sale {
	
	private String path = "Cashier/resource/Sales.txt";
	private int ID;
	
	private static List<Product> soldProduct = new ArrayList<Product>();
	private static List<Payment> paymentList = new ArrayList<Payment>();
	
	private String Date;
	private final double MOMS = 0.25;
	
	public Sale() {
		
	}
	
	public Sale(Payment payment) {
		paymentList.add(payment);
	}
	
	public double getTax() {
		return 0;
	}
	
	public void commitSale(List<Product> productList) {
		soldProduct.addAll(productList);
		for(int i = 0; i < soldProduct.size(); i++) {
			System.out.println(soldProduct.get(i).getProductName());
		}
	}
	
	public void reportFile() {
		double dayTotal = 0;
		List<String> dayTotalProducts = new ArrayList<String>();
		Report r = new Report(soldProduct);
		FileHandler fh = new FileHandler("/Report/" + r.reportName());
		
		for(int i = 0; i < soldProduct.size(); i++) {
			dayTotal += (double) soldProduct.get(i).getPrice();
			dayTotalProducts.add(soldProduct.get(i).getProductName());
		}
		fh.addLine("Day total:" + dayTotal + "\n" + r.printReport());
	}
	
	public double getSubTotal(List<Product> productList) {
		double subTotal = 0;
		for(int i = 0; i < productList.size(); i++) {
			subTotal += productList.get(i).getPrice();
			
		}
		return subTotal;
	}
	
}
