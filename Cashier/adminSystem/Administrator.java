package adminSystem;

public class Administrator extends User{

	private FileHandler handler;
	
	public Administrator(String firstName, String lastName) {
		super(firstName, lastName);
		
	}
	
	public String productLabel() {
		return null;
	}
}
