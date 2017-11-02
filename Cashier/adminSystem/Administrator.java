package adminSystem;

public class Administrator extends User{

	private Handler handler;
	
	public Administrator(String firstName, String lastName) {
		super(firstName, lastName);
		
	}
	
	public String productLabel() {
		return null;
	}
}
