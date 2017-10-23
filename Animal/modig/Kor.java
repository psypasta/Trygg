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
		
		Animal[] yolo = new Animal[4];
		
		yolo[0] = new DomesticCanary();
		yolo[1] = new AmericanRobin();
		yolo[2] = new RainbowTrout();
		yolo[3] = new SockeyeSalmon();
		
		yolo[0].eat();
		yolo[1].eat();
		yolo[2].eat();
		yolo[3].eat();
	}

}
