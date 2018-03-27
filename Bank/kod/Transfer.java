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
}