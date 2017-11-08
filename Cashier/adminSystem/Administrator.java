package adminSystem;

import adminSystem.FileFactory.UserInterface;

public class Administrator extends User implements UserInterface{

	//private FileHandler handler;

	public Administrator(String firstName, String lastName, Credential cred, Role role) {
		super(firstName, lastName, cred, role);
	//	role = Role.ADMIN;
	}
	
	public String productLabel() {
		return null;
	}

}
