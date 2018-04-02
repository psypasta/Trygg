package bank.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.transfer.Account;
import bank.transfer.Customer;

public class AccountCreation {
	
	private String accountNumber; 
	private String accountName;
	private Customer accountOwner;
	private String wealth;
	
	

//	Account account = new Account(accountNumber,accountName);

	
	
	public AccountCreation() {
		

		//Account account = new Account(accountNumber,accountName);

		List<String> accountList = new ArrayList<String>();

		
//		List<String> account = new ArrayList<String>();
//		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1. Skapa konto");
		System.out.println("2. Uttag / intag");
		String temp;
		
		temp = sc.nextLine();
		Account account = null;
		if(temp.equals("1")) {
			//Skapa konto
			String[] names = new String[2];
			System.out.println("Ange nummer: ");
			accountNumber = sc.next();
			System.out.println("Ange konto namn: ");
			accountName = sc.next();
			System.out.println("Ange ägarens förnamn: ");
			names[0] = sc.next();
			System.out.println("ANge ägarens efternamn: ");
			names[1] = sc.next();
			//detta känns inte bra
			
			
			account = new Account(accountNumber,accountName);
			account.setOwner(new Customer(names[0], names[1]));
			System.out.println(account.getAccountNumber() + " " + account.getBalance() + " " + account.getOwner().getFirstName());
			
			
		}
		else if(temp.equals("2")){
			System.out.println("Intag");
			System.out.println("Uttag");
			
		}
		
		else if(temp.equals("INTAG".toUpperCase())) {
			System.out.println("Ange konto: ");
			account.setOwner(accountOwner);
			
		}
		
		else if(temp.equals("UTTAG".toUpperCase())) {
			
		}
	
		
	}
	
	
		
		
	
	
	public static void main(String[] args) {
		
		new AccountCreation();
		
		
		
		
		
	}

}
