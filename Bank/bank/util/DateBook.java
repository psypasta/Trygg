package bank.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import bank.transfer.Transfer;

public class DateBook {

	
	//checkDates()
	//bookDate()
	//removeDate()
	
	public List<String> checkDates() {
		List<String> bookingsDate = new ArrayList();
		List<String> bookings = new ArrayList();;
		FileGet bookFile = new FileGet();
		bookings = bookFile.bookingsGet();
		
		GregorianCalendar gCalendar = new GregorianCalendar();
		SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
	    fmt.setCalendar(gCalendar);
	    String dateFormatted = fmt.format(gCalendar.getTime());
	    System.out.println("DATE FORMATTED" + dateFormatted);
	    
		for(int i = 0; i < bookings.size(); i++) {
			String[] words = bookings.get(i).split(" ");;
			if(words[3].equals(dateFormatted)) {
				bookingsDate.add(words[3]);
			}
		}
		
		
		return bookingsDate;
	}
	
	public DateBook() {
	
		
	}
	
	public void bookDate(Transfer transfer) {
		try{
		    String filename= "Bankdata/DatedTransfers";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    
		    
		    
		    fw.write(transfer.toString() + "\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe){
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
}
