package gui;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int tal = 0;
		
		tal = scan.nextInt();
		
		while(tal < 5) {
			System.out.println("Nytt tal");
			tal = scan.nextInt();
		}
		
	}

}
