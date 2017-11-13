package model.registerSystem;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.adminSystem.User;
import model.adminSystem.FileFactory.FileFactory;
import model.adminSystem.FileFactory.ProductFactory;
import model.adminSystem.FileFactory.UserFactory;
import model.saleReportSystem.Sale;
import view.Test;

public class Register {
	// Lägga till gånger antal istället för att skriva in samma vara flera
	// gånger.
	// product count
	private int productCount = 0;
	private int saleCount = 0;
	private double saldo = 2550;
	private double price = 0;

	private Test view = new Test();

//	private Product produces = new Product(1210, "Marabou stek choklad", 100, Product.Category.MEAT); //yum yum marabou k�tt

	private List<Product> productList = new ArrayList<Product>();
	private List<Receipt> kvittoList = new ArrayList<Receipt>();
	// List<Sale> salesList = new ArrayList<Sale>();
	private Sale snail;
// private Receipt kvitto;
//	private Sale s = new Sale(productList);
//	private File matFile = new File("Cashier/resource/mat.txt");
	
	private User user;

	public Register(User u, Test view) {
		this.user = u;
		this.view = view;

		view.run();
		kvittoList.add(new Receipt(user));
	}
    
	
	public void run() {
		
		Locale.setDefault(Locale.US); //This changes the locale to US no matter computer you are on. Should solve our decimal crash problem.	                                                         

		//Uses FileFactory class to create product object
		FileFactory pf = new ProductFactory();
				
		pf.createProduct(0);
		ArrayList<Product> testlist = new ArrayList<Product>(); //List over products from the text file
		
		Product[] parray;
		
		//Loop to fill testlist with product objects from products.txt
		for(int i = 0; i < pf.getLinesSize(); i++) {
			testlist.add(pf.createProduct(i));
		}
		
		//Main register loop
		while (true) {
			
			if (view.getData().equals("#2#")) {

				// kassan
				// kassan.commitSale();
				// Might be deprecated code between line 78 - 88, after the j.v fix with US language the decimals seems to be working without this.

				view.setData();
				price = printSum();
				// Added a way to round up "price" it shows in the console.
				double unrounded = price;
				NumberFormat fmt = NumberFormat.getNumberInstance();
				fmt.setMaximumFractionDigits(2);
				fmt.setRoundingMode(RoundingMode.CEILING);
				String value = fmt.format(unrounded);
				//System.out.println(value);
				//view.addLine(printSum())
				view.addLine( value + "");
				System.out.println("Betala: " + price);

			}

			// Commiting the sale, clearing the view inside GUI.


			//Commit sale condition

			else if (view.getData().equals("00")) {
				view.setData();
				kvittoList = commitSale();
				view.clearArea();
			} else {
				for (Product currentProduct : testlist) { // Foreach used so it can compare the ID input with all the products in the list - J.V

					if (view.getData().equals(currentProduct.getID())) {
						view.setData();
						System.out.print(currentProduct.getProductName() + (" "));
						System.out.println(currentProduct.getSort());
						System.out.println(currentProduct.getWeightUnit()); //Just here to check that it works
						addProduct(currentProduct);
						view.addProduct(currentProduct);
						
					}
				}
			}//Exits the program in its current form
			if (view.getData().equals("420")) {
				snail.reportFile();
				break;
			}
		}

		//prints the receipt to console
		for (int i = 0; i < kvittoList.size(); i++) {
			System.out.println(kvittoList.get(i).print());
		}
		view.destroy();
	}

	//add products to the kvitto and register list (productList)
	public void addProduct(Product p) {
		productList.add(p);
		kvittoList.get(saleCount).addLine(p);
	}

	//Method for printing sum of current products
	public double printSum() {
		snail = new Sale();
	//	System.out.println(snail.getSubTotal(productList) + "SNAIL");
		return snail.getSubTotal(productList);
	}

	//commits a sale. clears productsList, add kvittoList into receipt object.
	public List commitSale() {
		// TRANSAKTION
		// add sale to sale report system, remove product from lager, and add to ~
		// salereport. ~
		snail = new Sale();
		snail.commitSale(productList);
		productList = new ArrayList<Product>();
		kvittoList.add(new Receipt(user));

		//add one to salecount, which is used for indexing of kvittolist
		saleCount++;
		// return kvitto;
		return kvittoList;
	}

}