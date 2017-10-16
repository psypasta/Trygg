package modig;

public abstract class Fish extends Animal {

	public Fish(String k, String a) {
		super(k, a);
		
		}
	public void eat() {
		System.out.println("Eats krill, algae and insects");
	}
	
	public void move() {
		System.out.println("Swims through the waters");
	}
	
}
