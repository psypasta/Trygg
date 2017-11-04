package adminSystem;

import gui.LoginTest;

public class AdminMain {
	
	public static void main(String[] args) {
		
		LoginTest test2 = new LoginTest();
		test2.run();
		
		ProductReader pr = new ProductReader();
		pr.addLine("1210 Marabou Choklad 100");
		String productFile = pr.read();
		
		UserReader ur = new UserReader();
		ur.addLine("05 Sattar Password Admin");
		String userFile = ur.read();
		
		System.out.println(productFile);
		System.out.println(userFile);
		
		
		//dispose of window
		test2.setVisible(false);
		test2.dispose();
	}

}
