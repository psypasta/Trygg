package modig;


/*
 * 
 * Exercise CheckPassFail (if-else): 
 * Write a program called CheckPassFail which prints "PASS" if the int variable "mark" is more than or equal to 50; or prints "FAIL" otherwise.
 * The program shall always print “DONE” before exiting.
 * 
 * 
 * 
 */
public class CheckPassFail {
	
	public static void main(String[] args) {
		
		int mark = 50;
		
		
		
		if(mark >= 50) {
			System.out.println("PASS");
		}
		else if(mark <= 50) {
			System.out.println("FAIL");
		}
		System.out.println("DONE");
		
		int number = 50;
		
		if(number % 2 <= 0) {
			System.out.println("The number is Even " + number);
		}
		else {
			System.out.println("The number is Odd " +  number);
		}
	
	//CheckOddEven
	
	
	}

}
