package registerSystem;

import java.util.ArrayList;
import java.util.List;

import gui.LoginTest;
import gui.Test;

public class Main {

	public static void main(String[] args) {
		
		LoginTest test2 = new LoginTest();
		test2.run();
		
		Test test = new Test();
		test.run();

		Register kassan = new Register();
		Product produces = new Product(1210, "Marabou stek choklad", 100);
		List<Receipt> receiptList = new ArrayList<Receipt>();
		
		while(true) {
			
		//	System.out.println(test.getData());
			if(test.getData().equals("00")) {
	//			kassan
				test.setData();
				receiptList.add(kassan.getReceipt());
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
		
		kassan.commitSale();
		test.destroy(); 
		test2.setVisible(false);
		test2.dispose();
		
	}

}
