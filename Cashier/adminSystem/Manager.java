package adminSystem;

import adminSystem.User.Role;
import adminSystem.UserFactory.UserInterface;
import registerSystem.Product;
import saleReportSystem.Inventory;


//Manager hanterar salesreport systemet - dåligt namn?
public class Manager extends User implements UserInterface{

	Inventory i = new Inventory();
	
	public Role role;
	
	public Manager(String firstName, String lastName, Credentials cred) {
		super(firstName, lastName, cred);
		role = Role.MANAGER;
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
		// Lista ut vilka varor vi har i l�gt saldo, ska kunna markera vilken vara vi ska best�lla, sen en knapp f�r "best�ll"
	}
	
	public Role getRole() {
		return role;
	}
	
}

 



