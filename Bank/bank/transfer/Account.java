package bank.transfer;

public class Account {
	
	private String accountNumber;
	private String accountName;
//	private Customer accountOwner;
	private double accountBalance;

	public Account(String aNumber, String name) {
		this.accountNumber = aNumber;
		this.accountName = name;
	//	this.accountOwner = owner;
		this.accountBalance = 0;
	}
	
	public void deposit(double amount) {
		if(amount < 0) {
			System.out.println("invalid amount");
		}
		else {
			this.accountBalance = this.accountBalance + amount;
		}
	}
	
	public double withdraval(double amount) {
		if(this.accountBalance >= amount && this.accountBalance > 0) {
			this.accountBalance = this.accountBalance - amount;
			return amount;
		}
		else return 0;
	}
	
	public double getBalance() {
		return this.accountBalance;
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}

}
