package bank.transfer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import bank.accounts.Account;
import bank.util.FileGet;

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

	public void commit() {

	//	if(!commit) {
			to.deposit(from.withdraval(amount));
		//	double hold = from.withdraval(amount);
		//	to.deposit(hold);

			System.out.println(6 + " " + amount);
			FileGet updateSafe = new FileGet();
			updateSafe.modLine("Bankdata/safe", to.getAccountNumber(), String.valueOf(to.getBalance()));
			updateSafe.modLine("Bankdata/safe", from.getAccountNumber(), String.valueOf(from.getBalance()));
	//	}
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