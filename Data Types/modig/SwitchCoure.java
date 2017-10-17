package modig;
import java.util.Scanner;
public class SwitchCoure {

	


	//private static final char A = 0;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your character between A,B,C,D,E,: " );
		String givenChar = scanner.next();
		
		//char character = 'F';
		
		
		switch(givenChar.toUpperCase()) {
		case "A": 
			System.out.println("Your Character was " + givenChar + ", I got " + givenChar + " aswell:");
			break;
		case "B":
			System.out.println("Your Character was " + givenChar + ", I got " + givenChar + " aswell:");
			break;
		case "C": 
			System.out.println("Your Character was " + givenChar + ", I got " + givenChar + " aswell:");
			break;
		case "D":
			System.out.println("Your Character was " + givenChar + ", I got " + givenChar + " aswell:");
			break;
		case "E":
			System.out.println("Your Character was " + givenChar + ", I got " + givenChar + " aswell:");
			break;
			
	
			default:
				System.out.println("Didn't get correct character");
		}
		
		
		
			
			

	}

}
