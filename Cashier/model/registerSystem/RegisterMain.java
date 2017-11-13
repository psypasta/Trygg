package model.registerSystem;

import java.util.ArrayList;
import java.util.List;

import model.adminSystem.Credential;
import model.adminSystem.Employee;
import model.adminSystem.User;
import model.adminSystem.User.Role;
import view.Test;

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
