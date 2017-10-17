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
			System.out.println("Character was be A, I got to A aswell: " + givenChar);
			break;
		case "B":
			System.out.println("Character was be B, I got to A aswell: " + givenChar);
			break;
		case "C": 
			System.out.println("Character was be C, I got to A aswell: " + givenChar);
			break;
		case "D":
			System.out.println("Character was be D, I got to A aswell: " + givenChar);
			break;
		case "E":
			System.out.println("Character was be E, I got to A aswell: " + givenChar);
			break;
			
	
			default:
				System.out.println("Didnt find value");
		}
		
		
		
			
			

	}

}
