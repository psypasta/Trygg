package adminSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.UserFactory.UserFactory;
import gui.LoginTest;
import registerSystem.Product;

public class AdminMain {
	
	public static void main(String[] args) {
		
		Credentials cred = new Credentials(305);
		
		
		UserFactory uf = new UserFactory();
		User a = uf.getUser("EMPLOYEE", "Coolguy", "McHenk", cred);
		
		addUser(a);
		
		List<User> userList = new ArrayList<User>();
		
		LoginTest test2 = new LoginTest();
		test2.run();	
		
		UserHandler ur = new UserHandler();
		String userFile = ur.read();
		
		String[] lines = userFile.split(System.getProperty("line.separator"));
		String[] test = new String[4];
		
		for(int i = 0; i < lines.length; i++) {
			test = lines[i].split("\\s+");
			
			Credentials userName = null;
			String firstName = null;
			String lastName = null;
			String userType = null;
			
			
			for(int j = 0; j < test.length; j++) {
		//		System.out.println(j + " hej " + test[j]);
			
				if(j == 0) {
					userName = new Credentials(Integer.parseInt(test[j]));
				}else if(j == 1) {
					firstName = test[j];
				}else if(j == 2) {
					lastName = test[j];
				}else if(j == 3) {
					userType = test[j];
				}
		//		System.out.println(i + " index;" + lines[i]);
				
				}
			
			userList.add(uf.getUser(userType, firstName, lastName, userName));
			
		}
		
		System.out.println(userList.get(0).getFirstName() + userList.get(1).getFirstName());
		System.out.println(userList.get(6).getCredentials().getUserName());
		System.out.println("Length: " + lines.length);
		
		
		//dispose of window
		test2.setVisible(false);
		test2.dispose();
	}
	
	public void addProduct(Product p) {
		ProductHandler pr = new ProductHandler();
		pr.addLine(p.getID()  + " " + p.getProductName() + " " + p.getPrice());
	//	String productFile = pr.read();
	}
	public static void addUser(User u) {
		UserHandler ur = new UserHandler();
		ur.addLine(u.getCredentials().getUserName() + " " +
					u.getFirstName() + " " +
					u.getLastName() + " " +
					u.getRole());
	}
}