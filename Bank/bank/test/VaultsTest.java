package bank.test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

import bank.accounts.Account;
import bank.util.FileGet;
import bank.transfer.TransferManager;

public class VaultsTest {
	
	private List<Account> accountList;
	
	public VaultsTest(String operation, Scanner scan) {
		FileGet accountsFile = new FileGet();
		accountList = accountsFile.accountGet();

		String choice = operation;
		
		if(choice.equals("6")) {
			printAccounts();

		}
		else if(choice.equals("7")) {
			System.out.println("Enter account to remove to remove: (accountnumber)");
			choice = scan.nextLine();

			int match = TransferManager.findAccount(accountList, choice);
			try {
				accountsFile.deleteLine("Bankdata/accounts", accountList.get(match).toString());
				accountsFile.deleteLine("Bankdata/customers", accountList.get(match).getOwner().toString());
				accountsFile.deleteLine("Bankdata/safe", accountList.get(match).getAccountNumber() + ","
						  											  + accountList.get(match).getBalance());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(choice.equals("8")){

			double sum = 0;

			FileGet countMoneys = new FileGet();
			String contents = countMoneys.getLines("Bankdata/safe");
			String[] lines = contents.split("\n");
			for(int i = 0; i < lines.length; i++){
				String[] columns = lines[i].split(",");
				sum = sum + Double.parseDouble(columns[1]);
			}

			System.out.println("Sum of all accounts is: " + sum);
		}
		
//		else if(choice.equals("8")) {
			
//		}
	}

	public void printAccounts(){
		for(int i = 0; i < accountList.size(); i++){
			System.out.println(i+1 + ". " +
					accountList.get(i).getAccountNumber() + " " +
					accountList.get(i).getBalance() + " " +
					accountList.get(i).getOwner().getFirstName());
		}
	}
	
	public static void main(String[] args) {
		new VaultsTest("1", new Scanner(System.in));
	}
}
