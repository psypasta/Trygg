package bank.accounts;

public abstract class AbstractAccount {
	
	private String accountNumber;
	private String accountName;
	private Customer accountOwner;
	private double accountBalance;
    
	public AbstractAccount(String aNumber, String name) {
		this.accountNumber = aNumber;
		this.accountName = name;
		this.accountBalance = 0;
	}
	
	public void setOwner(Customer owner) {
		this.accountOwner = owner;
	}
	
	public Customer getOwner() {
		return this.accountOwner;
	}

	public void deposit(double amount) {
		System.out.println("7 " + amount);
		if(amount < 0) {
			System.out.println("invalid amount");
		}
		else {

			this.accountBalance = this.accountBalance + amount;
		}
	}
	
	public double withdraval(double amount) {

		if(amount > this.accountBalance){
			System.out.println("Medges ej");
			return 0;
		}
		else{
			this.accountBalance = this.accountBalance - amount;
			return amount;
		}

	/*	if(this.accountBalance >= amount && this.accountBalance > 0) {
			this.accountBalance = this.accountBalance - amount;
			return amount;
		}
		else return 0;*/
	}
	
	public double getBalance() {
		return this.accountBalance;
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public String toString() {
		return this.accountNumber + "," + this.accountName;
	}

}
