import java.util.Random;

public class Employee extends Person {
	
	private int salary = 0;
	
	private Random r = new Random();
	
	public Employee() {
		
	}
	
	public Employee(int i ) {
		super(i);
		
		age = r.nextInt(20) + 18;
		salary = r.nextInt(500) + 1000;
		name = "Jonas" + id;
		
		System.out.println(name);
		System.out.println("�lder: " + age);
		System.out.println("L�n: " + salary + " kr / h");
		
		
	}

	
}