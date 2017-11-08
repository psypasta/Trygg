package adminSystem;

import adminSystem.FileFactory.FileFactory;
import adminSystem.FileFactory.ProductFactory;
import adminSystem.FileFactory.UserFactory;
import gui.LoginTest;
import registerSystem.Product;

public class AdminMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginTest test2 = new LoginTest();
		test2.run();	
		
		FileFactory uf = new UserFactory();
		FileFactory pf = new ProductFactory();
	
		
		Product b = pf.createProduct(1);
		
		System.out.println("ID: " + b.getID());
		System.out.println("Pris: " + b.getPrice());
		System.out.println("Product name: " + b.getProductName());
		System.out.println("Catergory: " + b.getSort());
		
		
	  	User a = uf.createUser(1);
		System.out.println("First name: " + a.getFirstName());
		System.out.println("Last name: " + a.getLastName());
		System.out.println("Work hours: " + a.getWorkHours());
		System.out.println("Username: " + a.getCredentials().getUserName());
		System.out.println("Role: " + a.getRole());

		//dispose of window
			test2.setVisible(false);
			test2.dispose(); 
	}
}
