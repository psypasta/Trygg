package adminSystem;

import java.util.ArrayList;
import java.util.List;

import gui.LoginTest;

public class AdminMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginTest test2 = new LoginTest();
		test2.run();	
	
		FileFacade ff = new FileFacade();
		List<User> userList = new ArrayList<User>();
		
		userList = ff.userList();
		
		for(int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).getFirstName());
		}
		//dispose of window
			test2.setVisible(false);
			test2.dispose(); 
	}

}
