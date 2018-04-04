package bank.transfer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import bank.accounts.Account;

//3. Lägg in direkt betalning			Från Konto:
//4. Lägg in datum betalning			Till Konto:
//5. Ta bort datum betlaning			Belopp:

public class WireTransfer implements Transfer{

	private Account to;
	private Account from;
	private double amount;
	private Calendar transactionDate;
	
	public WireTransfer(Account to, Account from, double amount) {
		this.to = to;
		this.from = from;
		this.amount = amount;
	}
	
	public void finalize() {

		to.deposit(from.withdraval(amount));
		
		double hold = from.withdraval(amount);
		if(hold!=0) {
			to.deposit(hold);
		}
	}

    public String toString() {
    	String date = "";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		sdf.setCalendar(this.transactionDate);
	    date = sdf.format(this.transactionDate.getTime());
        return this.to.getAccountNumber() + " " + this.from.getAccountNumber() + " "
                + this.amount + " " + date;
    }
}