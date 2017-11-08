package adminSystem.FileFactory;

import adminSystem.Credential;
import adminSystem.User.Role;

public interface UserInterface {
	
	public Credential getCredentials();
	public String getFirstName();
	public String getLastName();
	public double getWorkHours();
	public Role getRole();
	
}
