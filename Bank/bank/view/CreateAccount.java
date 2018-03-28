package bank.view;

import java.util.ArrayList;
import java.util.List;

import bank.transfer.Account;
import bank.transfer.Customer;

public class CreateAccount {
	
	
	private String accountNumber;
	private String accountName;
	private Customer accountOwner;
	private double accountBalance;
	
	
	Account account;
	
	private List <Account> CreateAccount = new ArrayList<Account>();
		
		
	
	
	public List <Account> Create(){
		return this.CreateAccount;
	}
		
	
		
	
}
