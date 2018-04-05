package bank.test.throwaway;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.accounts.Account;
import bank.accounts.Customer;
import bank.util.FileGet;

public class AccountCreation {
	
	private String accountNumber; 
	private String accountName;
	private Customer accountOwner;

	private List<Account> accountList;
	
	public AccountCreation(String operation, Scanner sc) {

		accountList = new ArrayList<Account>();

		String temp = operation;
	
		if(temp.equals("1")) {
			//Skapa konto
			Account account;
			String[] names = new String[2];
			System.out.println("Enter account number: ");
			accountNumber = sc.nextLine();
			System.out.println("Enter account name: ");
			accountName = sc.nextLine();
			System.out.println("Enter owners first name: ");
			names[0] = sc.nextLine();
			System.out.println("Enter owners last name: ");
			names[1] = sc.nextLine();
			
			account = new Account(accountNumber,accountName);
			Customer customer = new Customer(names[0], names[1]);
			account.setOwner(customer);
			System.out.println(account.getAccountNumber() + " " + account.getBalance() + " " + account.getOwner().getFirstName());
			accountList.add(account);
			addLine("Bankdata/accounts", account.toString());
			addLine("Bankdata/customers", customer.toString());
			addLine("Bankdata/safe", account.getAccountNumber() + "," + account.getBalance());
		}
		
		else if(temp.equals("2")){
			System.out.println("3. Deposit");
			System.out.println("4. Withdraval");
			temp = sc.nextLine();
		}
		
		if(temp.equals("3")) {
			System.out.println("Enter account: ");
			String inAccountNumber = sc.nextLine();
			System.out.println("Enter amount: ");
			String inSaldo = sc.nextLine();
			for(int i = 0; i < accountList.size(); i++) {
				if(inAccountNumber.equals(accountList.get(i).getAccountNumber())) {
					accountList.get(i).deposit(Double.parseDouble(inSaldo));

					System.out.println(accountList.get(i).getAccountNumber() + " " + accountList.get(i).getBalance());
					FileGet updateSafe = new FileGet();
					updateSafe.modLine("Bankdata/safe", accountList.get(i).getAccountNumber(),
													String.valueOf(accountList.get(i).getBalance()));
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

					FileGet updateSafe = new FileGet();
					updateSafe.modLine("Bankdata/safe", accountList.get(i).getAccountNumber(),
							String.valueOf(accountList.get(i).getBalance()));
				}
			}
		}
	}

	public void addLine(String path, String addLine) {
		try{
			FileWriter fw = new FileWriter(path, true); //the true will append the new data
			fw.write(addLine + "\n");		//appends the string to the file
			fw.close();
		}
		catch(IOException ioe){
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	public static void main(String[] args) {
		new AccountCreation("1", new Scanner(System.in));
	}
}
