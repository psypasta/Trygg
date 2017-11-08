package adminSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.UserFactory.UserFactory;
import registerSystem.Product;

public class deletesoon {
	
	public List<User> userList() {
		UserFactory uf = new UserFactory();
		
		Credential cred = new Credential(305);
		User a = uf.getUser("EMPLOYEE", "Coolguy", "McHenk", cred);
		
		addUser(a);
		
		List<User> userList = new ArrayList<User>();
		
		FileHandler ur = new FileHandler();
		String userFile = ur.read();
		
		String[] lines = userFile.split(System.getProperty("line.separator"));
		String[] test = new String[4];
		
		for(int i = 0; i < lines.length; i++) {
			test = lines[i].split("\\s+");
			
			Credential userName = null;
			String firstName = null;
			String lastName = null;
			String userType = null;
			
			
			for(int j = 0; j < test.length; j++) {
		//		System.out.println(j + " hej " + test[j]);
			
				if(j == 0) {
					userName = new Credential(Integer.parseInt(test[j]));
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
		return userList;
		
		
	
	}
	
	public void addProduct(Product p) {
		ProductHandler pr = new ProductHandler();
		pr.addLine(p.getID()  + " " + p.getProductName() + " " + p.getPrice());
	//	String productFile = pr.read();
	}
	public void addUser(User u) {
		FileHandler ur = new FileHandler();
		ur.addLine(u.getCredentials().getUserName() + " " +
					u.getFirstName() + " " +
					u.getLastName() + " " +
					u.getRole());
	}
}