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
//		test.run();

		User user = new Employee("Max", "Blomstervall");
		List<Product> productList = new ArrayList<Product>();
		
		Register kassan = new Register(user, productList, test);
//		Product produces = new Product(1210, "Marabou stek choklad", 100);
		
//		List<Receipt> receiptList = new ArrayList<Receipt>();
		
		

		kassan.run();
		//dispose of window
//		test.destroy(); 
		
	}

}
