package adminSystem.FileFactory;

import adminSystem.Administrator;
import adminSystem.Credential;
import adminSystem.Employee;
import adminSystem.FileHandler;
import adminSystem.Manager;
import adminSystem.User;
import adminSystem.User.Role;
import registerSystem.Product;


public class UserFactory implements FileFactory{
	
	private Credential userName = null;
	private String firstName = null;
	private String lastName = null;
	private String userType = null;
	
	@Override
	public User createUser(int index/*String userType, String firstName, String lastName, Credential cred*/) {
	
		arrayChop(fileArray(), index);
		
		if(userType == null) {
			return null;
		}
		if(userType.equalsIgnoreCase("ADMIN")) {
			return new Administrator(firstName, lastName, userName, Role.ADMIN);
		}
		else if(userType.equalsIgnoreCase("MANAGER")) {
			return new Manager(firstName, lastName, userName, Role.MANAGER);
		}
		else if(userType.equalsIgnoreCase("EMPLOYEE")) {
			return new Employee(firstName, lastName, userName, Role.EMPLOYEE);
		}
		return null;
	}
	
	@Override
	public String[] fileArray() {
		FileHandler uh = new FileHandler();
		String userFile = uh.read("users.txt");
		
		String[] lines = userFile.split(System.getProperty("line.separator"));
		
		return lines;
	}
	
	@Override
	public String[] arrayChop(String[] lines, int index) {
		
		String[] test = new String[4];
		
		test = lines[index].split("\\s+");
		
		userName = null;
		firstName = null;
		lastName = null;
		userType = null;
		
		for(int j = 0; j < test.length; j++) {

			if(j == 0) {
				userName = new Credential(Integer.parseInt(test[j]));
			}else if(j == 1) {
				firstName = test[j];
			}else if(j == 2) {
				lastName = test[j];
			}else if(j == 3) {
				userType = test[j];
			}
		}
		return test;
	}

	@Override
	public Product createProduct(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLinesSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
