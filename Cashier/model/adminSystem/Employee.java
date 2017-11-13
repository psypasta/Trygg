package model.adminSystem;

import model.adminSystem.FileFactory.UserInterface;
import model.adminSystem.User.Role;

public class Employee extends User implements UserInterface{
	
	public Employee(String firstName, String lastName, Credential cred, Role role) {
		super(firstName, lastName, cred, role);
	//	role = Role.EMPLOYEE;
	}

}
