package adminSystem;

import adminSystem.User.Role;
import adminSystem.UserFactory.UserInterface;

public class Employee extends User implements UserInterface{
	
	public Role role;
	
	public Employee(String firstName, String lastName, Credentials cred) {
		super(firstName, lastName, cred);
		role = Role.EMPLOYEE;
	}
	
	public Role getRole() {
		return role;
	}
	

}
