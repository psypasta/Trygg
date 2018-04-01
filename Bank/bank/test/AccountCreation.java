package bank.test;

import java.util.Scanner;

import bank.transfer.Account;
import bank.transfer.Customer;

public class AccountCreation {
	
	private String accountNumber; 
	private String accountName;
	private Customer accountOwner;
	private String wealth;
	
	
	
	
	
	public AccountCreation() {
		
		Account account = new Account(accountNumber,accountName);
		
//		List<String> account = new ArrayList<String>();
//		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1. Skapa konto");
		System.out.println("2. Uttag / intag");
		String temp;
		
		temp = sc.nextLine();
	
		if(temp.equals("1")) {
			//Skapa konto
			System.out.println("Ange nummer: ");
			accountNumber = sc.next();
			System.out.println("Ange konto namn: ");
			accountName = sc.next();
			System.out.println("Ange ägarens namn: ");
			accountOwner = sc.next();
			System.out.println("Ange saldo: ");
			wealth = sc.next();
			//detta känns inte bra
			
		
			System.out.println(accountNumber + " " + accountName + " " + accountOwner + " " + wealth);
			
			
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
