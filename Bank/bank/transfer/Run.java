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
	
	private List<Account> accountList = new ArrayList<Account>();
	private List<Customer> customerList = new ArrayList<Customer>();
	private GregorianCalendar calendar;
	private void init() {
		
		FileGet accountFile = new FileGet();

		customerList = accountFile.customerList();
		String accountKey = "i + 00 + i + 0000";
		
		for(int i = 0; i < customerList.size(); i++) {
			accountList.add(customerList.get(i).getAccount());
			accountList.get(i).deposit(100);
		}
	}
	
	public Run() {
		init();
		Scanner scan = new Scanner(System.in);
		boolean calendarPlan = false;
		//Select operation
		
		System.out.println("3. Lägg in direkt betalning");
		System.out.println("4. Lägg in calenderbokning");
		//Select account
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
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH);
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
		
		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);
		
		if(toMatch!=-1 && fromMatch!=-1 && !calendarPlan) {
			Transfer p = new Transfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.finalize();
		}
		
		else if(toMatch!=-1 && fromMatch!=-1 && calendarPlan) {
			Transfer p = new Transfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.calendarFinalize(calendar);
		}
		/*
		System.out.println("Från: " + accountList.get(fromMatch).getAccountNumber() + " "
									+ accountList.get(fromMatch).getBalance());
		System.out.println("Till: " + accountList.get(toMatch).getAccountNumber() + " "
									+ accountList.get(toMatch).getBalance());*/

		scan.close();
	}
	
	public int findAccount(List<Account> aList, String find) {
		for(int i = 0; i < aList.size(); i++) {
			if(aList.get(i).getAccountNumber().equals(find)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		new Run();
		List finalizeDates = new ArrayList();
		DateBook db = new DateBook();
		finalizeDates = db.checkDates();
		System.out.println(finalizeDates.get(0));
	}
}
	
	
