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
	
	public VaultsTest() {
		FileGet accountsFile = new FileGet();
		accountList = accountsFile.accountGet();

		System.out.println("6. Lista konton");
		System.out.println("7. Avsluta konto");
		System.out.println("8. Visa bankvalv");
	
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		
		if(choice.equals("6")) {
			printAccounts();

		}
		else if(choice.equals("7")) {
			System.out.println("Välj konto att ta bort: (kontonummer)");
			choice = scan.nextLine();


			int match = TransferManager.findAccount(accountList, choice);
			try {

				accountsFile.deleteLine("Bankdata/accounts", accountList.get(match).toString());
				accountsFile.deleteLine("Bankdata/customers", accountList.get(match).getOwner().toString());
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
		new VaultsTest();
	}
}
