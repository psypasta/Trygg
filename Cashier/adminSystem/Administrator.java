package adminSystem;

import adminSystem.UserFactory.UserInterface;

public class Administrator extends User implements UserInterface{

	private FileHandler handler;
	
	private Role role;
	
	public Administrator(String firstName, String lastName, Credentials cred) {
		super(firstName, lastName, cred);
		role = Role.ADMIN;
	}
	
	public String productLabel() {
		return null;
	}
	
	public Role getRole() {
		return role;
	}
}
