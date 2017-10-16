package modig;

public abstract class Animal {
	
	private String kind = null;
	private String appearance  = null;
	
	
	public Animal(String k, String a) {
		this.kind = k;
		this.appearance = a;
	}

	public abstract void eat();
	public abstract void move();
	
	public String toString() {
		return kind + " " + appearance;
	}	
}
