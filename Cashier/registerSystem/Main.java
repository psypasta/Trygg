package registerSystem;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import adminSystem.Employee;
import adminSystem.ProductReader;
import adminSystem.User;
import adminSystem.UserReader;
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
		
		ProductReader pr = new ProductReader();
		pr.addLine("\n1210 Marabou Choklad 100");
		String productFile = pr.read();
		
		UserReader ur = new UserReader();
		String userFile = ur.read();
		
		System.out.println(productFile);
		System.out.println(userFile);
		
		
		while(true) {
			
		//	System.out.println(test.getData());
			if(test.getData().equals("00")) {
	//			kassan
		//		kassan.commitSale();
				test.setData();
				receiptList = kassan.commitSale();
				test.clearArea();
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
		
		test.destroy(); 
		test2.setVisible(false);
		test2.dispose();
		
	}

}
