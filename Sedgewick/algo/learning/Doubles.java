package algo.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doubles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Double> numberList = new ArrayList<Double>();
		
		double number = 0;
		number = (0 + 15) /2;
		
		numberList.add(number);
		
		number = 2.0e-6 * 100000000.1;

		numberList.add(number);
		
		boolean statemt = true && false || true && true;
		for(int i = 0; i < numberList.size(); i++) {
			System.out.println(numberList.get(i));
		}
		System.out.println(statemt);
		
		int a,b,c = 0;
		Scanner scan = new Scanner(System.in);

		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		
		if(a == b && b == c) {
			System.out.println("equal");
		}
		
		boolean numbState = false;
		double x,y = 0;
		x = 0.95;
		y= 0.15;
		if(x < 1 && x > 0 && y < 1 && y > 0) {
			numbState = true;
		}
		System.out.println(numbState);
		
		int f = 0;
		int g = 1;
		
		for(int i = 0; i < 15; i++) {
			System.out.println(f);
			f = f + g;
			g = f - g;
		}
	}

}
