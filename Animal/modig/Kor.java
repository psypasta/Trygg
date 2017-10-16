package modig;

public class Kor {

	public static void main(String[] args) {

		Animal robin = new AmericanRobin();
		System.out.println(robin.toString());
		robin.eat();
		robin.move();
		
		Animal salmon = new SockeyeSalmon();
		System.out.println("\n" + salmon.toString());
		salmon.eat();
		salmon.move();
	}

}
