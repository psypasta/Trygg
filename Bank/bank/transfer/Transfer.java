package bank.transfer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import bank.util.DateBook;

//3. Lägg in direkt betalning			Från Konto:
//4. Lägg in datum betalning			Till Konto:
//5. Ta bort datum betlaning			Belopp:

public class Transfer {

	private Account to;
	private Account from;
	private double amount;
	private Calendar transactionDate;
	
	
	public Transfer(Account to, Account from, double amount) {
		this.to = to;
		this.from = from;
		this.amount = amount;
	}
	
	public void finalize() {
		double hold = from.withdraval(amount);
		if(hold!=0) {
			to.deposit(hold);
		}
	}
	
	public void calendarFinalize(Calendar c) {

		this.transactionDate = c;
		DateBook dateToFile = new DateBook();
		dateToFile.bookDate(this);
	  /*System.out.println(sdf.format(transferDay.getTime()));
	    System.out.println(sdf.format(transferDay.getTime()));*/
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