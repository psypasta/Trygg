package bank.test.throwaway;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import bank.transfer.TransferManager;
import bank.util.DateBook;
import bank.util.FileGet;
public class TransactionTest {
	
	private GregorianCalendar calendar;
	private DateBook db = new DateBook();
	private TransferManager tm;
	/*
	public TransactionTest(String from, String to, double amount) {
		String operation = null;
		String from = null;
		String to = null;
		String finalizeDate = null;
		String transacDelete = null;
		Double amount = null;
	}
	
	public TransactionTest(String from, String to, double amount, String date) {
		String operation = null;
		String from = null;
		String to = null;
		String finalizeDate = null;
		String transacDelete = null;
		Double amount = null;
	} */
	
	public TransactionTest() {

		Scanner scan = new Scanner(System.in);
		boolean calendarPlan = false;
		//Select operation
		//Select accounts
		//Select amount
		String from;
		String to;
		double amount;
		
		System.out.println("3. Make a wire transfer");
		System.out.println("4. Add calendar payment");
		System.out.println("5. Remove calendar payment");
		
		to = scan.nextLine();
		if(to.equals("3")) {
			calendarPlan = false;
		}
		else if(to.equals("4")) {
			calendarPlan = true;
			String finalizeDate;
			System.out.println("Enter date for payment finalize: (mm/dd/yyyy): ");
			finalizeDate = scan.nextLine();
			System.out.println("Payment will finalize on: " + finalizeDate);
			
			calendar = new GregorianCalendar();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			try {
				calendar.setTime(sdf.parse(finalizeDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else if(to.equals("5")) {
			System.out.println("Enter a dated transaction to be removed: ");
			String transacDelete = scan.nextLine();
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
		
		System.out.println("From account: ");
		from = scan.nextLine();
		
		System.out.println("To account: ");
		to = scan.nextLine();
		
		System.out.println("Amount: ");
		amount = scan.nextDouble();
		if(amount < 0) {
			System.out.println("Can't transfer negative moneys!");
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
		List<String> finalizeDates;

		finalizeDates = db.checkDates();
		System.out.println("\nDates\n");
		for(int i  = 0; i < finalizeDates.size(); i++) {
			System.out.println(finalizeDates.get(i));
			String[] hold;
			hold = finalizeDates.get(i).split(" ");
			//	System.out.println(hold[0] + " " + hold[1] + " " + Double.parseDouble(hold[2]));
			tm.accountTransfer(hold[1], hold[0], Double.parseDouble(hold[2]));
		}
	}
	
	public static void main(String[] args) {
		new TransactionTest();
	}
}
	
	
