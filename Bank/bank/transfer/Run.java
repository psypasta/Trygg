package bank.transfer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import bank.util.DateBook;
import bank.util.FileGet;
public class Run {
	
	private static GregorianCalendar calendar;

	public static void main(String[] args) {
		
		System.out.println("3. Lägg in direkt betalning");
		System.out.println("4. Lägg in calenderbokning");
		
		Scanner scan = new Scanner(System.in);
		boolean calendarPlan = false;
		//Select operation
		//Select accounts
		//Select amount
		String from = "";
		String to = "";
		double amount = 0;
		
		to = scan.nextLine();
		if(to.equals("4")) {
			calendarPlan = true;
			
			String finalizeDate = "";
			System.out.println("Välj datum för betalning(mm/dd/yyyy): ");
			finalizeDate = scan.nextLine();
			System.out.println("Betalning går igenom den: " + finalizeDate);
			
			calendar = new GregorianCalendar();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			try {
				calendar.setTime(sdf.parse(finalizeDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(to.equals("3")) {
			calendarPlan = false;
		}
		
		to = "";
		
		System.out.println("Fr�n konto: ");
		from = scan.nextLine();
		
		System.out.println("Till konto: ");
		to = scan.nextLine();
		
		System.out.println("Summa: ");
		amount = scan.nextDouble();
		if(amount < 0) {
			System.out.println("Kan inte skicka minus pengar!");
			amount = scan.nextDouble();
		}
		
		scan.close();
		
		TransferManager tm = new TransferManager(calendar/*, calendarPlan*/);
		
		if(!calendarPlan) {
			tm.accountTransfer(from, to, amount);
		}
		else {
			tm.dateTransfer(from, to, amount);
		}
		
		List<String> finalizeDates = new ArrayList<String>();
		DateBook db = new DateBook();
		finalizeDates = db.checkDates();
		System.out.println("\nDates\n");
		for(int i  = 0; i < finalizeDates.size(); i++) {
			System.out.println(finalizeDates.get(i));
			String[] hold = new String[4];
			hold = finalizeDates.get(i).split(" ");
			System.out.println(hold[0] + " " + hold[1] + " " + Double.parseDouble(hold[2]));
			tm.accountTransfer(hold[0], hold[1], Double.parseDouble(hold[2]));
		}
	}
}
	
	
