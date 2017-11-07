package adminSystem.UserFactory;

import adminSystem.Credentials;
import adminSystem.User.Role;

public interface UserInterface {
	
	public Credentials getCredentials();
	public String getFirstName();
	public String getLastName();
	public int getID();
	public double getWorkHours();
	public Role getRole();
	
}
