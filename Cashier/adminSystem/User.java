package adminSystem;

public class User {
	
	private String firstName;
	private String lastName;
	private Credentials credentials;
	private static int ID;
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		credentials = new Credentials(firstName + ID, "password");
	}
}
