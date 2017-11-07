package adminSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.UserFactory.UserFactory;
import gui.LoginTest;

public class AdminMain {
	
	public static void main(String[] args) {
		
		Credentials cred = new Credentials(305);
		
		
		UserFactory uf = new UserFactory();
		User a = uf.getUser("ADMIN", "Coolguy", "McHenk", cred);
		User e = uf.getUser("EMPLOYEE", "Carl", "Danke", cred);
		User m = uf.getUser("MANAGER", "Karl", "Dragonpants", cred);
		
		List<User> userList = new ArrayList<User>();
		
		
		
		System.out.println(a.getRole());
		System.out.println(e.getRole());
		System.out.println(m.getRole());
		
		LoginTest test2 = new LoginTest();
		test2.run();
		
		ProductHandler pr = new ProductHandler();
		pr.addLine("1210 Marabou Choklad 100");
		String productFile = pr.read();
		
		UserHandler ur = new UserHandler();
		ur.addLine("305 Sattar Password Admin");
		String userFile = ur.read();
	//	System.out.println(userFile);
		
		String[] lines = userFile.split(System.getProperty("line.separator"));
		System.out.println("0 index;" + lines[0]);
		String[] test = new String[4];
		
		for(int i = 0; i < lines.length; i++) {
			test = lines[i].split("\\s+");
			
			Credentials userName = null;
			String firstName = null;
			String lastName = null;
			String userType = null;
			
			
			for(int j = 0; j < test.length; j++) {
				System.out.println(j + " hej " + test[j]);
			
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
		System.out.println(userList.get(6).getID() + " <- ID \n" + " Credentials ->" + userList.get(6).getCredentials().getUserName());
		System.out.println("Length: " + lines.length);
		
		
		//dispose of window
		test2.setVisible(false);
		test2.dispose();
	}

}
