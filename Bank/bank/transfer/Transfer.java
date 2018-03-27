package bank.transfer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

//3. Lägg in direkt betalning		Från Konto:
//4. Lägg in datum betalning			Till Konto:
//5. Ta bort datum betlaning			Belopp:

public class Transfer {

	private Account to;
	private Account from;
	private double amount;
	
	
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
	
/*	public Calendar calendarTransfer() {
		Scanner scan = new Scanner(System.in);
		int month, day = 0;
	//	System.out.println("Vilken månad vill du betala? ");
	//	month = scan.nextInt();
		System.out.println("Om hur många dagar vill du betala? ");
		day = scan.nextInt();
		
		GregorianCalendar transferDay = new GregorianCalendar();
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
	    System.out.println(sdf.format(transferDay.getTime()));
	    transferDay.add(transferDay.DAY_OF_YEAR, day);
	    System.out.println(sdf.format(transferDay.getTime()));
	
		return transferDay;
	}*/
}