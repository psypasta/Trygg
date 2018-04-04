package bank.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.accounts.Account;
import bank.accounts.Customer;

public class AccountCreation {
	
	private String accountNumber; 
	private String accountName;
	private Customer accountOwner;

	private List<Account> accountList;
	
	public AccountCreation() {

		accountList = new ArrayList<Account>();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Skapa konto");
		System.out.println("2. Uttag / intag");
		String temp;
		temp = sc.nextLine();
	
		if(temp.equals("1")) {
			//Skapa konto
			Account account = null;
			String[] names = new String[2];
			System.out.println("Ange nummer: ");
			accountNumber = sc.next();
			System.out.println("Ange konto namn: ");
			accountName = sc.next();
			System.out.println("Ange �garens f�rnamn: ");
			names[0] = sc.next();
			System.out.println("Ange �garens efternamn: ");
			names[1] = sc.next();
			
			account = new Account(accountNumber,accountName);
			account.setOwner(new Customer(names[0], names[1]));
			System.out.println(account.getAccountNumber() + " " + account.getBalance() + " " + account.getOwner().getFirstName());
			accountList.add(account);
		}
		
		else if(temp.equals("2")){
			System.out.println("3.Intag");
			System.out.println("4.Uttag");
			temp = sc.nextLine();
		}
		
		if(temp.equals("3")) {
			System.out.println("Ange konto: ");
			String inAccountNumber = sc.nextLine();
			System.out.println("Ange saldo: ");
			String inSaldo = sc.nextLine();
			for(int i = 0; i < accountList.size(); i++) {
				if(inAccountNumber.equals(accountList.get(i).getAccountNumber())) {
					accountList.get(i).deposit(Double.parseDouble(inSaldo));
				}
			}
		}
		
		else if(temp.equals("4")) {
			System.out.println("Ange konto: ");
			String outAccountNumber = sc.nextLine();
			System.out.println("Ange Saldo: ");
			String outSaldo = sc.nextLine();
			
			for(int i = 0; i < accountList.size(); i++) {
				if(outAccountNumber.equals(accountList.get(i).getAccountNumber())){
					accountList.get(i).withdraval(Double.parseDouble(outSaldo));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AccountCreation();
	}
}
