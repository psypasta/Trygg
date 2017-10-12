
public class Species {

	protected int id = 0;
	protected int age = 0;
	
	public Species() {
		
	}
	public Species(int i) {
		id = i;
	}
	
	public int getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}
}
