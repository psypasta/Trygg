package bank.transfer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bank.util.FileGet;

public class TransferManager {
	private List<Account> accountList = new ArrayList<Account>();
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private Calendar calendar;
//	private boolean calendarPlan = false;
	
	private void init() {
		
		FileGet accountFile = new FileGet();

		customerList = accountFile.customerList();
		
		for(int i = 0; i < customerList.size(); i++) {
			accountList.add(customerList.get(i).getAccount());
			accountList.get(i).deposit(100);
		}
	}
	
	public TransferManager(Calendar c/*, boolean calPlan*/) {
		init();
		
	//	this.calendarPlan = calPlan;
		this.calendar = c;
	}
	
	public void accountTransfer(String from, String to, double amount) {
		//Select operation
		//Select account
		//Select amount

		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);
		System.out.println(fromMatch);
		if(toMatch!=-1 && fromMatch!=-1/* && !calendarPlan*/) {
			Transfer p = new Transfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.finalize();
		}
	/*	else if(toMatch!=-1 && fromMatch!=-1 && calendarPlan) {
			Transfer p = new Transfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.calendarFinalize(calendar);
		} */
		System.out.println(fromMatch);
		System.out.println("Från: " + accountList.get(fromMatch).getAccountNumber() + " "
									+ accountList.get(fromMatch).getBalance());
		System.out.println("Till: " + accountList.get(toMatch).getAccountNumber() + " "
									+ accountList.get(toMatch).getBalance());
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
