package model.adminSystem;

import model.adminSystem.FileFactory.UserInterface;
import model.adminSystem.User.Role;
import model.registerSystem.Product;
import model.saleReportSystem.Inventory;


//Manager hanterar salesreport systemet - dåligt namn?
public class Manager extends User implements UserInterface{

	Inventory i = new Inventory();
	
	public Manager(String firstName, String lastName, Credential cred, Role role) {
		super(firstName, lastName, cred, role);
		//role = Role.MANAGER;
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
	
}

 



