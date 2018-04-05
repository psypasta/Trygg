package bank.transfer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import bank.accounts.Account;
import bank.util.DateBook;
import bank.util.FileGet;

public class DateTransfer implements Transfer {
	private Account to;
	private Account from;
	private double amount;
	private Calendar transactionDate;
	
	public DateTransfer(Account to, Account from, double amount, Calendar transactionDate) {
		this.to = to;
		this.from = from;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}
	
	public void commit() {
	/*	DateBook dateToFile = new DateBook();
		dateToFile.bookDate(this); */
		double hold = from.withdraval(amount);
		if(hold!=0) {
			to.deposit(hold);
		}

		System.out.println(6 + " " + amount);
		FileGet updateSafe = new FileGet();
		updateSafe.modLine("Bankdata/safe", to.getAccountNumber(), String.valueOf(to.getBalance()));
		updateSafe.modLine("Bankdata/safe", from.getAccountNumber(), String.valueOf(from.getBalance()));
	  /*System.out.println(sdf.format(transferDay.getTime()));
	    System.out.println(sdf.format(transferDay.getTime()));*/
	}
	
    public String toString() {
    	String date;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		sdf.setCalendar(this.transactionDate);
	    date = sdf.format(this.transactionDate.getTime());
        return this.to.getAccountNumber() + " " + this.from.getAccountNumber() + " "
                + this.amount + " " + date;
    }
}
