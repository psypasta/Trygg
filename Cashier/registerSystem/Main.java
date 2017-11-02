package registerSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.Employee;
import adminSystem.User;
import gui.LoginTest;
import gui.Test;

public class Main {

	public static void main(String[] args) {
		
		LoginTest test2 = new LoginTest();
		test2.run();
		
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
			}
			else if(test.getData().equals("10")) {
				test.setData();
				System.out.println("choklad");
				kassan.addProduct(produces);
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
		
		test.destroy(); 
		test2.setVisible(false);
		test2.dispose();
		
	}

}
