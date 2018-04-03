package bank.test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import bank.util.FileGet;

public class Test {
	
	private GregorianCalendar calendar;
	
	public Test() {
		TransactionTest t = new TransactionTest();
		Scanner scan = new Scanner(System.in);
		
		boolean calendarPlan = false;
		String operation = null;
		String from = null;
		String to = null;
		String finalizeDate = null;
		String transacDelete = null;
		Double amount = null;
		
		System.out.println("3. Lägg in direkt betalning");
		System.out.println("4. Lägg in kalender betalning");
		System.out.println("5. Ta bort kalender betalning");

		operation = scan.nextLine();
		
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
		
		System.out.println("Välj datum för betalning(mm/dd/yyyy): ");
		finalizeDate = scan.nextLine();
		System.out.println("Betalning går igenom den: " + finalizeDate);
			
		System.out.println("V�lj transaktion att ta bort : ");
		transacDelete = scan.nextLine();
		System.out.println(": " + transacDelete);
		
		if(to.equals("3")) {
			calendarPlan = false;
		}
		else if(to.equals("4")) {
			calendarPlan = true;
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
			transacDelete = scan.nextLine();
			System.out.println(": " + transacDelete);
			FileGet transac = new FileGet();
			try {
				transac.deleteLine("Bankdata/DatedTransfers", transacDelete);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	/*
	 * from - account
	 * to - account 
	 * amount - amount
	 * 
	 * Operation:
	 * 		WireTransfer
	 * 
	 *	 		from - account
	 * 			to - account 
	 * 			amount - amount
	 * 
	 * 		Calendar
	 * 
	 * 	 		from - account
	 * 			to - account 
	 * 			amount - amount
	 * 			System.out.println("Välj datum för betalning(mm/dd/yyyy): ")
	 * 
	 * 		Remove Calendar
	 * 
	 * 			System.out.println("V�lj transaktion att ta bort : ");
	 * 
	 */
	
	public static void main(String[] args) {
		new Test();

	}

}
