package modig;

public abstract class Bird extends Animal {

	public Bird(String k, String a) {
		super(k, a);
		
	}
	
	public void eat() {
		System.out.println("Eats seeds and insects");
	}

	public void move() {
		System.out.println("Flies through the air");
	}
}
