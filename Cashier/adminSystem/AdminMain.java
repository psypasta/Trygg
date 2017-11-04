package adminSystem;

import gui.LoginTest;

public class AdminMain {
	
	public static void main(String[] args) {
		
		LoginTest test2 = new LoginTest();
		test2.run();
		
		ProductHandler pr = new ProductHandler();
		pr.addLine("1210 Marabou Choklad 100");
		String productFile = pr.read();
		
		UserHandler ur = new UserHandler();
		ur.addLine("05 Sattar Password Admin");
		String userFile = ur.read();
		
		System.out.println(productFile);
		System.out.println(userFile);
		
		//dispose of window
		test2.setVisible(false);
		test2.dispose();
	}

}
