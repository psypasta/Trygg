import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Run {
	
	private List<Account> accountList = new ArrayList();
	private List<Customer> customerList = new ArrayList();
	
	private void init() {
		accountList.add(new Account("100-10000", "Konto 1"));
		accountList.add(new Account("200-20000", "Konto 2"));
		accountList.add(new Account("300-30000", "Konto 3"));
		accountList.add(new Account("400-40000", "Konto 4"));
		accountList.add(new Account("500-50000", "Konto 5"));

		customerList.add(new Customer(accountList.get(0), "Clas", "Ohlson"));
		customerList.add(new Customer(accountList.get(1), "Max", "Blomstervall"));
		customerList.add(new Customer(accountList.get(2), "Henrik", "Yxbåge"));
		customerList.add(new Customer(accountList.get(3), "Patrik", "Sparsam"));
		customerList.add(new Customer(accountList.get(4), "Johan", "Andersson"));
		
		accountList.get(0).deposit(2000);
		accountList.get(1).deposit(4000);
		accountList.get(2).deposit(7000);
		accountList.get(3).deposit(0);
		accountList.get(4).deposit(-100.0);
		accountList.get(4).withdraval(100);
	}
	
	public Run() {
		init();
		Scanner scan = new Scanner(System.in);
		
		//Select operation
		System.out.println("3. Lägg in direkt betalning");
	
		//Select account
		//Select amount
		String from = "";
		String to = "";
		double amount = 0;
		
		System.out.println("Från konto: ");
		from = scan.nextLine();
		
		System.out.println("Till konto: ");
		to = scan.nextLine();
		
		System.out.println("Summa: ");
		amount = scan.nextDouble();
		
		int toMatch = findAccount(accountList, to);
		int fromMatch = findAccount(accountList, from);
		if(toMatch!=-1 && fromMatch!=-1) {
			Transfer p = new Transfer(accountList.get(toMatch), accountList.get(fromMatch), amount);
			p.finalize();
		}
		
		System.out.println("Från: " + accountList.get(fromMatch).getAccountNumber() + " " + accountList.get(fromMatch).getBalance());
		System.out.println("Till: " + accountList.get(toMatch).getAccountNumber() + " " + accountList.get(toMatch).getBalance());
		
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
	}
}
	
	
