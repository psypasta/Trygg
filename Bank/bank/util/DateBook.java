package bank.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import bank.transfer.Transfer;

public class DateBook {

	public DateBook() {
	
	}
	//checkDates()
	//bookDate()
	//removeDate()
	
	public List<String> checkDates() {
		List<String> bookingsDate = new ArrayList<String>();
		List<String> bookings;
		FileGet bookFile = new FileGet();
		bookings = bookFile.bookingsGet();
		
		GregorianCalendar gCalendar = new GregorianCalendar();
		SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
	    fmt.setCalendar(gCalendar);
	    String dateFormatted = fmt.format(gCalendar.getTime());
	    
		for(int i = 0; i < bookings.size(); i++) {
			String[] words = bookings.get(i).split(" ");
			if(words[3].equals(dateFormatted)) {
				bookingsDate.add(words[0] + " " + words[1] + " " + words[2] + " " + words[3] + " " + words[4]);
			}
		}
		return bookingsDate;
	}

	public void bookDate(Transfer transfer) {
		try{
		    String filename= "Bankdata/DatedTransfers";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    
		    fw.write(transfer.toString() + "\n");		//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe){
		    System.err.println("IOException: " + ioe.getMessage());
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

	public void removeDate(String path, String compare) throws FileNotFoundException, UnsupportedEncodingException {
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
	
}
