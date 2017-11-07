package adminSystem;

public class Credentials {
	
	private int userName;
//	private String password;
	
	public Credentials(int userName/*, String password*/) {
		this.userName = userName;
//		this.password = password;
	}

	public int getUserName() {
		return userName;
	}
//public boolean login(int userName/*, String password*/) {
	//	if(this.userName == userName)/* && this.userName.equals(password))*/ {
	/*		return true;
		}
		else {
			return false;
		}
	}*/
}
