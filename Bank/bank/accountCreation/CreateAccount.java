package bank.accountCreation;

import java.util.ArrayList;
import java.util.List;

import bank.transfer.Account;
import bank.transfer.Customer;
import bank.util.FileGet;

public class CreateAccount {
	
	private List <Account> createAccount;
	private String accountNumber;
	private String accountName;
	private Customer accountOwner;
	private double accountBalance;
	
	public CreateAccount() {
		FileGet file = new FileGet();
		
		createAccount =
		file.accountList();
		
	}
	//Account account;
	
	
		
	//
	
	public List <Account> getAccountList(){
		return this.createAccount;
	}
		
	
		
	
}
