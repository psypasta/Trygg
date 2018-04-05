package bank.transfer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import bank.accounts.Account;
import bank.util.DateBook;
import bank.util.FileGet;

public class TransferManager {
	private List<Account> accountList = new ArrayList<Account>();

	private Calendar calendar;
	
	private void init() {
		
		FileGet accountFile = new FileGet();

		accountList = accountFile.accountGet();
	}
	
	public TransferManager(Calendar c) {
		init();
		this.calendar = c;
	}
	
	public void dateTransfer(String from, String to, double amount) {
		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);

		DateBook db = new DateBook();
		System.out.println(toMatch + "  " + fromMatch);
		if(toMatch!=-1 && fromMatch!=-1) {
			Transfer p = new DateTransfer(accountList.get(toMatch), accountList.get(fromMatch), amount, calendar);

			System.out.println(calendar.getTime());
			System.out.println(new GregorianCalendar().getTime());
			if(calendar.getTime().after(new GregorianCalendar().getTime())){
				db.bookDate(p);
			}
			else {
				p.commit();
			}
		}

		if(toMatch!=-1 && fromMatch!=-1) {
			System.out.println("From: " + accountList.get(fromMatch).getAccountNumber() + " "
										+ accountList.get(fromMatch).getBalance());
			System.out.println("To: " + accountList.get(toMatch).getAccountNumber() + " "
										+ accountList.get(toMatch).getBalance());
		}
	}

	public void accountTransfer(String from, String to, double amount) {
		System.out.println(2 + " " + amount);
		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);

		if(toMatch!=-1 && fromMatch!=-1/* && !calendarPlan*/) {
			System.out.println(3 + " " + amount);
			Transfer p = new WireTransfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.commit();
			System.out.println(4 + " " + amount);
/*
			FileGet updateSafe = new FileGet();
			updateSafe.modLine("Bankdata/safe", accountList.get(toMatch).getAccountNumber()
					,String.valueOf(accountList.get(toMatch).getBalance()));
			updateSafe.modLine("Bankdata/safe", accountList.get(fromMatch).getAccountNumber()
					,String.valueOf( accountList.get(fromMatch).getBalance()));
*/
		}
		
		if(toMatch!=-1 && fromMatch!=-1) {
			System.out.println("From: " + accountList.get(fromMatch).getAccountNumber() + " "
										+ accountList.get(fromMatch).getBalance());
			System.out.println("To: " + accountList.get(toMatch).getAccountNumber() + " "
										+ accountList.get(toMatch).getBalance());
		}
	}

	public static int findAccount(List<Account> aList, String find) {
		for(int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getAccountNumber().equals(find)) {
				return i;
			}
		}
		return -1;
	}
	
}
