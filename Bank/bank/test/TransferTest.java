package bank.test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import bank.transfer.TransferManager;
import bank.util.DateBook;
import bank.util.FileGet;

public class TransferTest {


	
	public TransferTest(String operation, Scanner scan) {
		String from;
		String to;
		String finalizeDate;
		double amount;

		System.out.println(operation);
		if(operation.equals("3")) {
			System.out.println("From account: ");
			from = scan.nextLine();
			System.out.println("To account: ");
			to = scan.nextLine();
			System.out.println("Amount: ");
			amount = Double.parseDouble(scan.nextLine());

			if(amount < 0) {
				System.out.println("Can't transfer negative moneys!");
				amount = scan.nextDouble();
			}

			TransferManager wireTm = new TransferManager(new GregorianCalendar());
			System.out.println(1 + " " + amount);
			wireTm.accountTransfer(from, to, amount);
		}
		
		else if(operation.equals("4")) {
			GregorianCalendar calendar;

			System.out.println("From account: ");
			from = scan.nextLine();
			System.out.println("To account: ");
			to = scan.nextLine();
			System.out.println("Amount: ");
			amount = Double.parseDouble(scan.nextLine());
			
			if(amount < 0) {
				System.out.println("Can't transfer negative moneys!");
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
		}
		
		else if(operation.equals("5")) {
			System.out.println("Enter your reference number to remove a transaction (xxxxx): ");
			String transacDelete = scan.nextLine();

			scan.close();

			System.out.println("Removing: " + transacDelete);
			DateBook transac = new DateBook();
			try {
				transac.removeDate("Bankdata/DatedTransfers", transacDelete);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		String operation;

		System.out.println("3. Make a wire transfer");
		System.out.println("4. Add calendar payment");
		System.out.println("5. Remove calendar payment");

		Scanner initialScanner = new Scanner(System.in);
		operation = initialScanner.nextLine();

		new TransferTest(operation, initialScanner);
	}

}