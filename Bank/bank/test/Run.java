package bank.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import bank.transfer.TransferManager;
import bank.util.DateBook;
public class Run {
	
	private GregorianCalendar calendar;
	private DateBook db = new DateBook();
	private TransferManager tm;
	
	public Run() {

		Scanner scan = new Scanner(System.in);
		boolean calendarPlan = false;
		//Select operation
		//Select accounts
		//Select amount
		String from = "";
		String to = "";
		double amount = 0;
		
		System.out.println("3. Lägg in direkt betalning");
		System.out.println("4. Lägg in kalender betalning");
		System.out.println("5. Ta bort kalender betalning");
		
		to = scan.nextLine();
		if(to.equals("3")) {
			calendarPlan = false;
		}
		else if(to.equals("4")) {
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
				e.printStackTrace();
			}
		}
		else if(to.equals("5")) {
			System.out.println("V�lj transaktion att ta bort : ");
			String transacDelete = scan.nextLine();
			System.out.println(": " + transacDelete);
		}
		
		to = "";
		
		System.out.println("Från konto: ");
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
		
		tm = new TransferManager(calendar/*, calendarPlan*/);
		
		if(!calendarPlan) {
			tm.accountTransfer(from, to, amount);
		}
		else {
			tm.dateTransfer(from, to, amount);
		}
		
		finalizeDates();
	}
	
	public void finalizeDates() {
		List<String> finalizeDates = new ArrayList<String>();
		
		finalizeDates = db.checkDates();
		System.out.println("\nDates\n");
		for(int i  = 0; i < finalizeDates.size(); i++) {
			System.out.println(finalizeDates.get(i));
			String[] hold = new String[4];
			hold = finalizeDates.get(i).split(" ");
		//	System.out.println(hold[0] + " " + hold[1] + " " + Double.parseDouble(hold[2]));
			tm.accountTransfer(hold[1], hold[0], Double.parseDouble(hold[2]));
		}
	}
	
	public static void main(String[] args) {
		new Run();
	}
}
	
	
