package bank.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import bank.accounts.AbstractAccount;
import bank.accounts.Account;
import bank.accounts.Customer;
import bank.transfer.TransferManager;
import bank.util.FileGet;

public class AccountTest {

	public static void main(String[] args) {
		new AccountTest("1", new Scanner(System.in));
	}

	private Customer accountOwner;
	private List<Account> accountList;
	public AccountTest(String operation, Scanner scan) {
		init();
		AbstractAccount a = null;

		if(operation.equals("1")){
			a = inputsToAccount(scan);

			System.out.println(a.toString());
			System.out.println(accountOwner.toString());
			stringToFile(a.toString(), "Bankdata/accounts");
			stringToFile(accountOwner.toString(), "Bankdata/customers");
			stringToFile(a.getAccountNumber() + "," + a.getBalance(), "Bankdata/safe");
		}
		else if(operation.equals("2")){
			System.out.println("1. Deposit");
			System.out.println("2. Withdrawal");
			String choice = scan.nextLine();

			if(choice.equals("1")) {
				System.out.println("Enter account: ");
				String accountNumber = scan.nextLine();
				System.out.println("Enter amount: ");
				String amount = scan.nextLine();

				int indexOf = TransferManager.findAccount(accountList, accountNumber);
				accountList.get(indexOf).deposit(Double.parseDouble(amount));

				FileGet updateSafe = new FileGet();
				updateSafe.modLine("Bankdata/safe", accountList.get(indexOf).getAccountNumber(),
						String.valueOf(accountList.get(indexOf).getBalance()));
			}
			else if(choice.equals("2")){
				System.out.println("Enter account: ");
				String accountNumber = scan.nextLine();
				System.out.println("Enter amount: ");
				String amount = scan.nextLine();

				int indexOf = TransferManager.findAccount(accountList, accountNumber);
				accountList.get(indexOf).withdraval(Double.parseDouble(amount));

				FileGet updateSafe = new FileGet();
				updateSafe.modLine("Bankdata/safe", accountList.get(indexOf).getAccountNumber(),
						String.valueOf(accountList.get(indexOf).getBalance()));
			}
		}

	}

	private void init() {

		FileGet accountFile = new FileGet();
		accountList = accountFile.accountGet();
	}

	private AbstractAccount inputsToAccount(Scanner scan){

		String accountNumber;
		String accountName;

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
