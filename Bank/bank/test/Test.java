package bank.test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import bank.transfer.TransferManager;
import bank.util.FileGet;

public class Test {
	
	private GregorianCalendar calendar;
	
	public Test() {
		TransactionTest t = new TransactionTest();
		
		
		boolean calendarPlan = false;
		String operation = null;
		String from = null;
		String to = null;
		String finalizeDate = null;
		Double amount = null;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("3. Make a wire transfer");
		System.out.println("4. Add calendar payment");
		System.out.println("5. Remove calendar payment");
		
	    operation = scan.nextLine();
	    scan.close();
		System.out.println(operation);
		if(operation.equals("3")) {
			System.out.println("From account: ");
			from = scan.nextLine();
			System.out.println("To account: ");
			to = scan.nextLine();
			System.out.println("Amount: ");
			amount = scan.nextDouble();
			if(amount < 0) {
				System.out.println("Can't transfer negative moenys!");
				amount = scan.nextDouble();
			}					
			TransferManager wireTm = new TransferManager(new GregorianCalendar());
			wireTm.accountTransfer(from, to, amount);
		}
		
		else if(operation.equals("4")) {
			System.out.println("From account: ");
			from = scan.nextLine();
			System.out.println("To account: ");
			to = scan.nextLine();
			System.out.println("Amount: ");
			amount = scan.nextDouble();
			
			if(amount < 0) {
				System.out.println("Can't transfer negative moenys!");
				amount = scan.nextDouble();
			}		
			
			System.out.println("Enter date for payment finalize (mm/dd/yyyy): ");
			finalizeDate = scan.nextLine();
			System.out.println("Payment will finalize on: " + finalizeDate);
			
			calendar = new GregorianCalendar();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			try {
				calendar.setTime(sdf.parse(finalizeDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			TransferManager dateTm = new TransferManager(calendar);
			dateTm.dateTransfer(from, to, amount);
			 /* 
			 * 	 		from - account
			 * 			to - account 
			 * 			amount - amount
			 * 			System.out.println("Välj datum för betalning(mm/dd/yyyy): ")
			 */
		}
		
		else if(operation.equals("5")) {
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
		scan.close();
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
	 */
	public static void main(String[] args) {
		new Test();
	}

}