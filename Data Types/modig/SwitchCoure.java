package modig;
import java.util.Scanner;
public class SwitchCoure {

	


	//private static final char A = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your character between A,B,C,D,E,: " );
		String givenChar = scanner.next();
		
		//char character = 'F';
		
		
		switch(givenChar) {
		case "A": case "a":
			System.out.println("Character was be A, I got to A aswell: " + givenChar);
			break;
		case "B": case "b":
			System.out.println("Character was be B, I got to A aswell: " + givenChar);
			break;
		case "C": case "c":
			System.out.println("Character was be C, I got to A aswell: " + givenChar);
			break;
		case "D": case "d":
			System.out.println("Character was be D, I got to A aswell: " + givenChar);
			break;
		case "E": case "e":
			System.out.println("Character was be E, I got to A aswell: " + givenChar);
			break;
			
	
			default:
				System.out.println("Didnt find value");
				break;
		}
		
		
		
			
			

	}

}
