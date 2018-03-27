package bank.transfer;

public class Customer {
	
	private Account customerAccount;
	private String firstName;
	private String lastName;
	
	public Customer(Account a, String f, String l) {
		this.customerAccount = a;
		this.firstName = f;
		this.lastName = l;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public Account getAccount() {
		return this.customerAccount;
	}
}
