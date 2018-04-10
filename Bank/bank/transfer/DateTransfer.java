package bank.transfer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import bank.accounts.Account;
import bank.util.DateBook;
import bank.util.FileGet;
import bank.util.KeyGen;

public class DateTransfer extends Transfer {
	
	public DateTransfer(Account to, Account from, double amount, Calendar transactionDate) {
		this.to = to;
		this.from = from;
		this.amount = amount;
		this.transactionDate = transactionDate;

		setId();
	}

	private void setId() {
		FileGet fg = new FileGet();
		String currentContent = fg.getLines("Bankdata/DatedTransfers");

		KeyGen k = new KeyGen();
		String id = k.getKey();

		while (currentContent.contains(id))
			id = k.getKey();

	//	if(!currentContent.contains(Integer.toString(id))){
			this.transferId = id;
			System.out.println("Your reference number is:  " + this.transferId);
	//	}
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
                + this.amount + " " + date + " " + this.transferId;
    }
}
