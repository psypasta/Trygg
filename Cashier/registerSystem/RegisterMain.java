package registerSystem;

import java.util.ArrayList;
import java.util.List;

import adminSystem.Credential;
import adminSystem.Employee;
import adminSystem.User;
import adminSystem.User.Role;
import gui.Test;

public class RegisterMain {

	//Main start point for register program.
	public static void main(String[] args) {		
		
		Test test = new Test();
		
		Credential cred = new Credential(420);
		User user = new Employee("Max", "Blomstervall", cred, Role.EMPLOYEE);	
		Register kassan = new Register(user, test);

		kassan.run();

	}

}
