package adventure.game;

public class Player {

	private String name = null;
	private int age = 0;
	
	public Player(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void action() {
		this.age+=1;
	}
	
	public String sayName() {
		return this.name;
	}
	public String sayAge() {
		return Integer.toString(this.age);
	}
}
