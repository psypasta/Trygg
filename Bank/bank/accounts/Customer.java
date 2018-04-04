package bank.accounts;

public class Customer {
	
	private String firstName;
	private String lastName;
	
	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String toString() {
		return this.firstName + "," + this.lastName;
	}
}
