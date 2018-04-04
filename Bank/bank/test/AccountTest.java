package bank.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bank.accounts.AbstractAccount;
import bank.accounts.Account;
import bank.accounts.Customer;

public class AccountTest {

	public static void main(String[] args) {
		new AccountTest();
	}
	
	public AccountTest() {

		Scanner scan = new Scanner(System.in);
		
		String accountNumber = scan.nextLine();
		String accountName = scan.nextLine();
		Customer accountOwner = new Customer(scan.nextLine(), scan.nextLine());
		//double accountBalance = scan.nextDouble();
		
		AbstractAccount a = new Account(accountNumber, accountName);
		a.setOwner(accountOwner);
		
		System.out.println(a.toString());
		System.out.println(accountOwner.toString());
		stringToFile(a.toString(), "Bankdata/accounts");
		stringToFile(accountOwner.toString(), "Bankdata/customers");
	}
	
	private void stringToFile(String input, String path) {
		try{
			String filename= path;
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    
		    fw.write(input + "\n");		//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe){
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}

}
