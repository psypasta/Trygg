
public class Test {

	public static void main(String[] args) {
		
		Object [] obj = new Object[10];
		obj[0] = new Person(0);
		obj[1] = new Animal(0);
		obj[2] = new Student(0, "Matte");
		obj[3] = new Employee(0);
		obj[4] = new Tiger(0);
		obj[5] = new Lion(0);
		
		
		System.out.println(((Species) obj[0]).getId());
		System.out.println(((Species) obj[3]).getId());
		System.out.println(((Student) obj[2]).getCourse());
		
	}

}
