package adminSystem.UserFactory;

import adminSystem.FileHandler;
import adminSystem.User;
import registerSystem.Product;
import registerSystem.Product.Category;

public class ProductFactory implements FileFactory {

	private int ID = 0;
	private String productName = null;
	private double price = 0.0;
	private String category = null;
	
	@Override
	public Product createProduct(int index/*String userType, String firstName, String lastName, Credential cred*/) {
	
		arrayChop(fileArray(), index);

		if(category == null) {
			return null;
		}
		else if(category.equalsIgnoreCase("MEAT")) {
			return new Product(ID, productName, price, Category.MEAT);
		}
		else if(category.equalsIgnoreCase("DAIRY")) {
			return new Product(ID, productName, price, Category.DAIRY);
		}
		else if(category.equalsIgnoreCase("FRUIT")) {
			return new Product(ID, productName, price, Category.FRUIT);
		}	
		else if(category.equalsIgnoreCase("VEGETABLE")) {
			return new Product(ID, productName, price, Category.VEGETABLE);
		}
		
		return null;
	}
	
	@Override
	public String[] fileArray() {
		FileHandler uh = new FileHandler();
		String userFile = uh.read("products.txt");
		
		String[] lines = userFile.split(System.getProperty("line.separator"));
		
		return lines;
	}
	
	@Override
	public String[] arrayChop(String[] lines, int index) {
		
		String[] test = new String[4];
		
		test = lines[index].split("\\s+");
		
	/*	ID = 0;
		productName = null;
		price = 0.0;
		category = null; */
		
		for(int j = 0; j < test.length; j++) {
			if(j == 0) {
				category = test[j];
				
			}else if(j == 1) {
				//wtf varför är denna unit? Hur kan arrayen bli 5 stor? när jag deklarerat den 4 på rad 52?
				System.out.println(j + " index " + test[j]);
			}else if(j == 2) {
				ID = Integer.parseInt(test[j]);
			}else if(j == 3) {
				productName = test[j];
			}
			else if(j == 4) {
				price = Double.parseDouble(test[j]);
			}
		} 
		return test;
	}

	@Override
	public User createUser(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
