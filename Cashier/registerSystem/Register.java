package registerSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adminSystem.Employee;
import adminSystem.User;

public class Register {
	
	//product count
	private int productCount;
	private int saleCount = 0;
	
	private List <Product> productList = new ArrayList<Product>();
	private List<Receipt> kvittoList = new ArrayList<Receipt>();
//	private Receipt kvitto;
	private Sale s = new Sale(productList);
	private File matFile = new File("Cashier/resource/mat.txt");
	
	
	private User user;
	
	public Register(User u) {
		this.user = u;
		kvittoList.add(new Receipt());
	}
	
	public void addProduct(Product p) {
		productList.add(p);
		kvittoList.get(saleCount).addLine(p);
	}
	
		
	public List commitSale() {
		//TRANSAKTION
		//add sale to sale report system, remove product from lager, and add to ~ salereport. ~ 
		kvittoList.add(new Receipt());
		
		saleCount++;
	//	return kvitto;
		return kvittoList;
	}
	
	//drop this
	public void openMattxt() {
//		String code = null;
		//	code = scanKeyboard.nextLine();
			
			//Scanner to read keyboard input
			Scanner scanKeyboard = new Scanner(System.in);
			
			//Scanner to read a file
			Scanner scanFile;
			try {
					scanFile = new Scanner (matFile);
				
					while(true) {
				    String code = scanFile.nextLine(); // looks at selected file in scan
				    if(code.charAt(0) == '#') {
				    	code = scanFile.nextLine();
				    }
				    else if(code == "") {
				    	code = scanFile.nextLine();
				    }
				    String inpCode = scanKeyboard.nextLine(); // gets input from user
				    System.out.println(code + " <- fileLine + keyboardLine -> " + inpCode);
				    
				    if (inpCode.equals(code)) {
				        System.out.print("Din code : " + code);
				        break;
				    } else {
				        System.out.print("your error message");
				    }
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public double weigh() {
		return 0;
	}
}
