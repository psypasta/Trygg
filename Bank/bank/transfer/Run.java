package bank.transfer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bank.util.FileGet;
public class Run {
	
	private List<Account> accountList = new ArrayList<Account>();
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private void init() {
		
		FileGet accountFile = new FileGet();

		customerList = accountFile.customerList();
		String accountKey = "i + 00 + i + 0000";
		
		for(int i = 0; i < customerList.size(); i++) {
			accountList.add(customerList.get(i).getAccount());
			accountList.get(i).deposit(100);
		}
	}
	
	public Run() {
		init();
		Scanner scan = new Scanner(System.in);
		
		//Select operation
		System.out.println("3. Lägg in direkt betalning");
	
		//Select account
		//Select amount
		String from = "";
		String to = "";
		double amount = 0;
		
		System.out.println("Från konto: ");
		from = scan.nextLine();
		
		System.out.println("Till konto: ");
		to = scan.nextLine();
		
		System.out.println("Summa: ");
		amount = scan.nextDouble();
		if(amount < 0) {
			System.out.println("Kan inte skicka minus pengar!");
			amount = scan.nextDouble();
		}
		
		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);

		if(toMatch!=-1 && fromMatch!=-1) {
			Transfer p = new Transfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.finalize();
		}
		
		System.out.println("Från: " + accountList.get(fromMatch).getAccountNumber() + " " + accountList.get(fromMatch).getBalance());
		System.out.println("Till: " + accountList.get(toMatch).getAccountNumber() + " " + accountList.get(toMatch).getBalance());

		scan.close();
	}
	
	public int findAccount(List<Account> aList, String find) {
		for(int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getAccountNumber().equals(find)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		new Run();
	}
}
	
	
