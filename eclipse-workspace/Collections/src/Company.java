import java.util.Collection;
import java.util.ArrayList;
public class Company {

	Collection<Employee> foo = new ArrayList<Employee>();
	
	Collection<Employee> hire(int n) {
		
		
		for(int i = 0; i < n; i++) {
			Employee e = new Employee(i);
			foo.add(e);
		
		}
		
		return foo;
	}
	
	void fire() {
		System.out.println(foo);
		foo.remove(foo);
		System.out.println(foo);
	}
	
	
	
}