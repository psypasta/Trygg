package adminSystem.UserFactory;

import adminSystem.Administrator;
import adminSystem.Credentials;
import adminSystem.Employee;
import adminSystem.Manager;
import adminSystem.User;

public class UserFactory {
	public User getUser(String userType, String firstName, String lastName, Credentials cred) {
		if(userType == null) {
			return null;
		}
		if(userType.equalsIgnoreCase("ADMIN")) {
			return new Administrator(firstName, lastName, cred);
		}
		else if(userType.equalsIgnoreCase("MANAGER")) {
			return new Manager(firstName, lastName, cred);
		}
		else if(userType.equalsIgnoreCase("EMPLOYEE")) {
			return new Employee(firstName, lastName, cred);
		}
		return null;
	}
	
	
}
