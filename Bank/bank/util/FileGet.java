package bank.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import bank.accounts.Account;
import bank.accounts.Customer;

public class FileGet {

	public String getLines(String path) {
		String contents = "";
		File file = new File(path);
		Scanner sc = null;

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			while (sc.hasNextLine()) {
				contents += sc.nextLine() + "\n";
			}
		} catch(NullPointerException e){

		}
		return contents;
	}

	public void modLine(String path, String find, String mod){
		String contents = getLines(path);
	//	System.out.println(contents);
		String[] lines = contents.split("\n");
		contents = "";
		for(int i = 0; i < lines.length; i++){
			if(lines[i].contains(find)){
				lines[i] = find + "," + mod;
			}

	//		System.out.println(lines[i]);
			contents = contents + lines[i] + "\n";
		}

		try {
			PrintWriter writer = new PrintWriter(path);
			writer.print(contents);
			writer.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private int findIndexMatch(List<String> aList, String find) {
		for(int i = 0; i < aList.size(); i++) {
			String[] splitLines = aList.get(i).split(" ");
			if(splitLines[4].toLowerCase().matches(find.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	public void deleteLine(String path, String compare) throws FileNotFoundException, UnsupportedEncodingException {
		ArrayList<String> lines = new ArrayList<String>();
		
		Scanner scan = new Scanner(new File(path));
		while (scan.hasNext())
			    lines.add(scan.nextLine());
		int indexToRemove = findIndexMatch(lines, compare);
		if(indexToRemove != -1) {
			lines.remove(indexToRemove);
			PrintWriter writer = new PrintWriter(path, "UTF-8");
			for (int i = 0; i < lines.size(); i++) {
				writer.println(lines.get(i));
				System.out.println(lines.get(i));
			}

			writer.close();
		}
	}
	
	public List<String> bookingsGet(){

		String[] lines = getLines("Bankdata/DatedTransfers").split("\n");
		List<String> bookingsList = Arrays.asList(lines);

		return bookingsList;
	}
	//plsfix this class
	private List<Customer> customerGet(List<Account> accountList) {
		List<Customer> customerList = new ArrayList<Customer>();
		String[] lines = getLines("Bankdata/customers").split("\n");
		for(int i = 0; i < lines.length; i++) {
			String[] words;
			words = lines[i].split(",");
			Customer holdCustomer = new Customer(words[0], words[1]);
			customerList.add(holdCustomer);
			accountList.get(i).setOwner(holdCustomer);
		}
		return customerList;
	}
	
	public List<Account> accountGet() {
		
		List<Account> accountList = new ArrayList<Account>();
		String[] accountLines = getLines("Bankdata/accounts").split("\n");
		String[] safeLines = getLines("Bankdata/safe").split("\n");

		for(int i = 0; i < accountLines.length; i++) {
			String[] accountS;
			String[] safeS;
			accountS = accountLines[i].split(",");
			safeS = safeLines[i].split(",");
			Account holdAccount = new Account(accountS[0], accountS[1]);
			holdAccount.deposit(Double.parseDouble(safeS[1]));
			accountList.add(holdAccount);
		}
		
		customerGet(accountList);
		return accountList;
	}
}
