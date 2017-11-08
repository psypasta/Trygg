package adminSystem;

import adminSystem.User.Role;
import adminSystem.UserFactory.UserInterface;

public class Employee extends User implements UserInterface{
	
	public Employee(String firstName, String lastName, Credential cred, Role role) {
		super(firstName, lastName, cred, role);
	//	role = Role.EMPLOYEE;
	}

}
