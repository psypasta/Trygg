package adminSystem;

import registerSystem.Product;
import saleReportSystem.Inventory;

public class Manager extends User {

	Inventory i = new Inventory();
	
	public Manager(String firstName, String lastName) {
		super(firstName, lastName);
		
	}

	public int inventoryProduct(Product p)
	{
		
		return 0;
	}
	public String openReport()
	{
		return null;
		
	}
	public void orderProduct(int numberOfProduct, Product p)
	{
		// Lista ut vilka varor vi har i lågt saldo, ska kunna markera vilken vara vi ska beställa, sen en knapp för "beställ"
	}
	
}

 



