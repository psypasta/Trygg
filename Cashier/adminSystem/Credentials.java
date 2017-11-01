package adminSystem;

public class Credentials {
	
	private String userName;
	private String password;
	
	public Credentials(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public boolean login(String userName, String password) {
		if(this.userName.equals(userName) && this.userName.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
}
