package registerSystem;

import java.util.List;

public class Sale {
	private int ID;
	private String Date;
	private final double MOMS = 0.25;
	private Payment payment;
	
	public Sale(List productList) {
		getSubTotal(productList);
	}
	
	public double getTax() {
		return 0;
	}
	
	public double getSubTotal(List<Product> productList) {
		
		for(int i = 0; i < productList.size(); i++) {
			System.out.println(productList.get(i).getPrice()); //hjälp	
		}
		
		return 0;
	}
	
	public double getTotal() {
		
		
		
		return 0;
	}
	
	public void setPayment() {
		
	}
	
}
