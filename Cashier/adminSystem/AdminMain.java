package adminSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.UserFactory.FileFactory;
import adminSystem.UserFactory.ProductFactory;
import adminSystem.UserFactory.UserFactory;
import gui.LoginTest;

public class AdminMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginTest test2 = new LoginTest();
		test2.run();	
		
		FileFactory uf = new UserFactory();
	//	FileFactory pf = new ProductFactory();
	
		User a = uf.createUser(1);
	//	pf.createProduct(1);
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
