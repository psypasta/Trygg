package bank.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.transfer.Account;
import bank.transfer.Customer;

public class FileGet {

	public List<String> bookingsGet(){
		List<String> linesFromFile = new ArrayList<String>();
		// pass the path to the file as a parameter
		File file =
    		new File("Bankdata/DatedTransfers");
    		Scanner sc = null;
    	
    		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 
		while (sc.hasNextLine()) {
			String s = "";
			s = sc.nextLine();
			linesFromFile.add(s);
   		}
		return linesFromFile;	
	}
	//plsfix this class
	public List<Customer> customerGet(List<Account> accountList) {
		
		List<Customer> customerList = new ArrayList<Customer>();
		// pass the path to the file as a parameter
		File file =
    		new File("Bankdata/customers");
    		Scanner sc = null;
    	
    		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 
    	int i = 0;
		while (sc.hasNextLine()) {
			String[] s = new String[2];
			s = sc.nextLine().split(",");
			Customer holdCustomer = new Customer(s[0], s[1]);
			customerList.add(holdCustomer);
			accountList.get(i).setOwner(holdCustomer);
			i+=1;
   		}
		return customerList;
	}
	
	public List<Account> accountList() {
		
		List<Account> accountList = new ArrayList<Account>();
		// pass the path to the file as a parameter
		File file =
    		new File("Bankdata/accounts");
    		Scanner sc = null;
    	
    		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 
		while (sc.hasNextLine()) {
			String[] s = new String[2];
			s = sc.nextLine().split(",");
			Account hold = new Account(s[0], s[1]);
			accountList.add(hold);
   		}
		customerGet(accountList);
		return accountList;
	}
}