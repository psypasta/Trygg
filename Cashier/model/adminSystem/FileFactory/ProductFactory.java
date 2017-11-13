package model.adminSystem.FileFactory;

import model.adminSystem.FileHandler;
import model.adminSystem.User;
import model.registerSystem.Product;

//ProductFactory is a class to abstract away the creation of objects. 
//Maybe it should be of prototype pattern instead, idk - it works
public class ProductFactory implements FileFactory {
	
	//Fields to save data from text file in
	private String ID = null;
	private String productName = null;
	private double price = 0.0;
	private String category = null;
	//Field to count lines in text file
	private static int linesSize = 0;
	
	//Return line size is needed if you want to make loop the object creation.
	public int getLinesSize() {
		return linesSize;
	}

	@Override //Main object creation method returns a object created in from the text files.
	//Takes an index which corresponds to a line in the textfile
	public Product createProduct(int index/*String userType, String firstName, String lastName, Credential cred*/) {
	
		//calls forth the array chopping. chops the text file into a 4 unit long 
		arrayChop(fileArray(), index);
		
		//Returns an object to the callar, om 
		return new Product(ID, productName, price, category);
	}
	
	
	//Chops the text file into a string array. One element per line
	@Override
	public String[] fileArray() {
		FileHandler uh = new FileHandler();
		String userFile = uh.read("productsTest.txt");
		//FileHandler class reads text file into a string
		//System.getProperty("line.separator"); funkade med products.txt, men inte productsTest.txt
		/*
		 * If you don’t want empty lines:
		 * String.split("[\\r\\n]+") tänk på detta max :)
		 *///userFile split on the new lines into a String []
		String[] lines = userFile.split("\\r?\\n");
		//set linesSize so that we know the size of the string, for looping and creational purposes
		linesSize = lines.length;
		return lines;
	}
	
	//chops a stray array into a smaller string array of four elements.
	@Override
	public String[] arrayChop(String[] lines, int index) {
		
		String[] test = new String[4];
		test = lines[index].split("\\s+");
		
	/*	ID = 0;
		productName = null;
		price = 0.0;
		category = null; */
		//assigns the fields, split on spaces into the small array 
		for(int j = 0; j < test.length; j++) {
			if(j == 0) {
				ID = test[j];
			}
			else if(j == 1) {
				productName = test[j];
			}else if(j == 2) {
				price = Double.parseDouble(test[j]);
			}
			else if(j == 3) {
				category = test[j];
			}
		/*
		 * products.txt
			if(j == 0) {
				category = test[j]; // this is old code
				
			}
			else if(j == 1) {
				//wtf varför är denna unit? Hur kan arrayen bli 5 stor? när jag deklarerat den 4 på rad 52?
				System.out.println(j + " index " + test[j]);
			}
			else if(j == 2) {
				ID = Integer.parseInt(test[j]);
			}else if(j == 3) {
				productName = test[j];
			}
			else if(j == 4) {
				price = Double.parseDouble(test[j]);
			}*/
		} 
		
		return test;
	}

	@Override
	public User createUser(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
