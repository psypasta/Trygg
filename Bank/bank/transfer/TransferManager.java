package bank.transfer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bank.accounts.Account;
import bank.util.FileGet;

public class TransferManager {
	private List<Account> accountList = new ArrayList<Account>();
	
	private Calendar calendar;
	
	private void init() {
		
		FileGet accountFile = new FileGet();

		accountList = accountFile.accountGet();
		
		for(int i = 0; i < accountList.size(); i++) {
	//		accountList.add(customerList.get(i).getAccount());
	//		System.out.println(accountList.get(i).getAccountNumber());
	//		System.out.println(accountList.get(i).getBalance());
	//		System.out.println(accountList.get(i).getOwner().getFirstName());
	//		System.out.println(accountList.get(i).getOwner().getLastName());
			accountList.get(i).deposit(1000);
		}
	}
	
	public TransferManager(Calendar c) {
		init();
		this.calendar = c;
	}
	
	public void dateTransfer(String from, String to, double amount) {
		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);
		
		if(toMatch!=-1 && fromMatch!=-1) {
			Transfer p = new DateTransfer(accountList.get(toMatch), accountList.get(fromMatch), amount, calendar);
			p.finalize();
		}
		
		if(toMatch!=-1 && fromMatch!=-1) {
			System.out.println("From: " + accountList.get(fromMatch).getAccountNumber() + " "
										+ accountList.get(fromMatch).getBalance());
			System.out.println("To: " + accountList.get(toMatch).getAccountNumber() + " "
										+ accountList.get(toMatch).getBalance());
		}
	}
	
	public void accountTransfer(String from, String to, double amount) {

		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);
		
		if(toMatch!=-1 && fromMatch!=-1/* && !calendarPlan*/) {
			Transfer p = new WireTransfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.finalize();
		}
		
		if(toMatch!=-1 && fromMatch!=-1) {
			System.out.println("From: " + accountList.get(fromMatch).getAccountNumber() + " "
										+ accountList.get(fromMatch).getBalance());
			System.out.println("To: " + accountList.get(toMatch).getAccountNumber() + " "
										+ accountList.get(toMatch).getBalance());
		}
	}
	
	public int findAccount(List<Account> aList, String find) {
		for(int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getAccountNumber().equals(find)) {
				return i;
			}
		}
		return -1;
	}
	
}
