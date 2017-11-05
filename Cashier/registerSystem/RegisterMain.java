package registerSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.Employee;
import adminSystem.User;
import gui.Test;

//ingen av dessa implementationer är final >

public class RegisterMain {

	public static void main(String[] args) {		
		
		Test test = new Test();
		test.run();

		User user = new Employee("Max", "Blomstervall");
		
		Register kassan = new Register(user);
		Product produces = new Product(1210, "Marabou stek choklad", 100);
		List<Receipt> receiptList = new ArrayList<Receipt>();
		
		while(true) {
			
		//	System.out.println(test.getData());
			if(test.getData().equals("00")) {
	//			kassan
		//		kassan.commitSale();
				test.setData();
				receiptList = kassan.commitSale();
				test.clearArea();
				
				System.out.println("Betala: " + kassan.getPrice());
			}
			else if(test.getData().equals("10")) {
				test.setData();
				System.out.println("choklad");
				kassan.addProduct(produces);
				test.addProduct(produces);
			}
			if(test.getData().equals("420")) {
				break;
			}
		//	System.out.println(test.getData());
		}
		
		for(int i = 0; i < receiptList.size(); i++) {
	//		System.out.println(receiptList.size());
			System.out.println(receiptList.get(i).getData());
		}
		
		
		//dispose of window
		test.destroy(); 
		
	}

}
