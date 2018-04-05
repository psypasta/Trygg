package bank.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bank.accounts.AbstractAccount;
import bank.accounts.Account;
import bank.accounts.Customer;
import bank.util.FileGet;

public class AccountTest {

	public static void main(String[] args) {
		new AccountTest();
	}

	private String accountNumber;
	private String accountName;
	private Customer accountOwner;


	public AccountTest() {

		AbstractAccount a = inputsToAccount();

		System.out.println(a.toString());
		System.out.println(accountOwner.toString());
		stringToFile(a.toString(), "Bankdata/accounts");
		stringToFile(accountOwner.toString(), "Bankdata/customers");
		stringToFile(a.getAccountNumber() + "," + a.getBalance(), "Bankdata/safe");
	}

	private AbstractAccount inputsToAccount(){
		Scanner scan = new Scanner(System.in);
		FileGet fg = new FileGet();

		String accountFile = fg.getLines("Bankdata/accounts");

		System.out.println("Enter account number: ");
		accountNumber = scan.nextLine();
		System.out.print("Enter account name: ");
		accountName = scan.nextLine();
		System.out.println("Enter first name: ");
		String fName = scan.nextLine();
		System.out.println("Enter last name: ");
		String lName = scan.nextLine();
		accountOwner = new Customer(fName, lName);
		System.out.println(accountFile.contains(accountNumber));
		while(accountFile.contains(accountNumber)){
			System.out.println("Account number already exists, Re-enter: ");
			accountNumber = scan.nextLine();
		}

		AbstractAccount a = new Account(accountNumber, accountName);
		a.setOwner(accountOwner);

		return a;
	}

	private void stringToFile(String input, String path) {
		try{
		    FileWriter fw = new FileWriter(path,true); //the true will append the new data
		    
		    fw.write(input + "\n");		//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe){
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}

}
