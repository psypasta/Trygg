package modig;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class ArrayListExercise {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] testStringArray = new String[3];
		String testString = null;
		int i = 0;
		while(true) {
			testString = sc.nextLine();
			System.out.println(testString);
			testStringArray[i] = testString;
			for(int c = 0; c < testStringArray.length; c++) {
				
				
			}
			Arrays.sort(testStringArray);
			System.out.println(Arrays.toString(testStringArray));
			i++;
		}
		
		//0ax,Albin,Robin = Albin, 
		
		
	}
	

}
