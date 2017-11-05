package registerSystem;

import java.util.List;

public class Sale {
	
	private String path = "Cashier/resource/Sales.txt";
	private int ID;
	private String Date;
	private final double MOMS = 0.25;
	private Payment payment;
	
	public Sale(List productList) {
	//	System.out.println(getSubTotal(productList));
	}
	
	public double getTax() {
		return 0;
	}
	
	public double getSubTotal(List<Product> productList) {
		double sum = 0;
		for(int i = 0; i < productList.size(); i++) {
		//	System.out.println(productList.get(i).getPrice()); //hjälp	
			sum += productList.get(i).getPrice();
		}
		
		return sum;
	}
	
	public double getTotal() {
		
		
		
		return 0;
	}
	
	public void setPayment() {
		
	}
	
}
