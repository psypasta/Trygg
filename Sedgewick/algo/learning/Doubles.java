package algo.learning;

import java.util.ArrayList;
import java.util.List;

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
	}

}
