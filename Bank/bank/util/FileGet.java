package bank.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.transfer.Account;
import bank.transfer.Customer;

public class FileGet {

	public String getLines(String path) {
		String contents = null;
		File file =
	    		new File(path);
	    		Scanner sc = null;
	    	
	    		try {
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	 
			while (sc.hasNextLine()) {
				contents += sc.nextLine() + "\n";
	   		}
			return contents;
	}
	
	public void deleteLine(String path, String compare) throws FileNotFoundException, UnsupportedEncodingException {
		ArrayList<String> lines = new ArrayList<String>();
		
		 Scanner scan = new Scanner(new File(path));
		 while (scan.hasNext())
			    lines.add(scan.nextLine());
		
		 lines.remove(compare);
		 PrintWriter writer = new PrintWriter(path, "UTF-8");
		 for (int i = 0; i < lines.size(); i++)
		     writer.println(lines.get(i));
		 writer.close();
	}
	
	public List<String> bookingsGet(){

		List<String> bookingsList = new ArrayList<String>();
		List<Account> accountList = accountGet();
		String[] lines = getLines("Bankdata/DatedTransfers").split("\n");
		for (int i = 0; i < lines.length; i++) {
			bookingsList.add(lines[i]);
   		}
		return bookingsList;
	}
	//plsfix this class
	private List<Customer> customerGet(List<Account> accountList) {
		List<Customer> customerList = new ArrayList<Customer>();
		String[] lines = getLines("Bankdata/customers").split("\n");
		for(int i = 0; i < lines.length; i++) {
			String[] s = new String[2];
			s = lines[i].split(",");
			Customer holdCustomer = new Customer(s[0], s[1]);
			customerList.add(holdCustomer);
			accountList.get(i).setOwner(holdCustomer);
		}
		return customerList;
	}
	
	public List<Account> accountGet() {
		
		List<Account> accountList = new ArrayList<Account>();
		String[] lines = getLines("Bankdata/accounts").split("\n");
		
		for(int i = 0; i < lines.length; i++) {
			String[] s = new String[2];
			s = lines[i].split(",");
			Account holdAccount = new Account(s[0], s[1]);
			accountList.add(holdAccount);
		}
		
		customerGet(accountList);
		return accountList;
	}
}
