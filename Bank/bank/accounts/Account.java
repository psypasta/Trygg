package bank.accounts;

public class Account extends AbstractAccount {
	
	private String accountNumber;
	private String accountName;
	private Customer accountOwner;
	private double accountBalance;

	public Account(String aNumber, String name) {
		super(aNumber, name);
	}
}
