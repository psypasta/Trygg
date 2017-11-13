package model.adminSystem.FileFactory;

import model.adminSystem.Credential;
import model.adminSystem.User.Role;

public interface UserInterface {
	
	public Credential getCredentials();
	public String getFirstName();
	public String getLastName();
	public double getWorkHours();
	public Role getRole();
	
}
