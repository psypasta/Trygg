package adminSystem;

public class User {
	
	private String firstName;
	private String lastName;
	private Credentials credentials;
	private static int ID;
	
	
	//Skall lagra tid fr�n n�r man loggar in till n�r man loggar ut. N�r man har loggat ut skall workHours sparas till fil
	//reset 30 dagar
	private double workHours = 0;
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		credentials = new Credentials(firstName + ID, "password");
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public static int getID() {
		return ID;
	}

	public double getWorkHours() {
		return workHours;
	}
}
