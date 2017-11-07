package adminSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import adminSystem.UserFactory.UserInterface;
import registerSystem.Product;

public class User implements UserInterface {
	
	private String firstName;
	private String lastName;
	private Credentials credentials;
	private int ID;
	private double workHours = 0;
	//Skall lagra tid fr�n n�r man loggar in till n�r man loggar ut. N�r man har loggat ut skall workHours sparas till fil
	//reset 30 dagar
	
	public enum Role {
	    EMPLOYEE, MANAGER, ADMIN
	}
	
	public User(String firstName, String lastName, Credentials cred) {
		this.firstName = firstName;
		this.lastName = lastName;
		credentials = cred;
		ID = cred.getUserName();
	}

	public Credentials getCredentials(){
		return credentials;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getID() {
		return ID;
	}

	public double getWorkHours() {
		return workHours;
	}

	@Override
	public Role getRole() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
