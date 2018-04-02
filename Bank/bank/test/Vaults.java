package bank.test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

import bank.transfer.Account;
import bank.util.FileGet;

public class Vaults {
	
	private List<Account> accountList;
	
	public Vaults() {
		System.out.println("6. Lista konton");
		System.out.println("7. Avsluta konto");
		System.out.println("8. Visa bankvalv");
	
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		
	//	if(choice.equals("6")) {
			FileGet accounts = new FileGet();
			accountList = accounts.accountGet();
			for(int i = 0; i < accountList.size(); i++) {
				System.out.println(i + ". " +
									accountList.get(i).getAccountNumber() + " " +
									accountList.get(i).getBalance() + " " +
									accountList.get(i).getOwner().getFirstName());
			}
	//	}
//		else if(choice.equals("7")) {
			System.out.println("Välj index att ta bort: ");
			choice = scan.nextLine();
			try {
				accounts.deleteLine("Bankdata/accounts", accountList.get(Integer.parseInt(choice)).toString());
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
			
//		}	
		
//		else if(choice.equals("8")) {
			
//		}
	}
	
	public static void main(String[] args) {
		new Vaults();
	}
}
