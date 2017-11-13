package registerSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adminSystem.User;
import gui.Test;

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
		kvittoList.add(new Receipt());
	}

	public void run() {
		ArrayList<Product> testlist = new ArrayList<Product>(); //List over products from the text file
		                                                         

		try {
			Scanner txtIn = new Scanner(new File("Cashier/resource/productsTest.txt")); //Temporary text file that has deleted everything except the products themselves - J.V
			while (txtIn.hasNext()) {
				String id = txtIn.next();
				String name = txtIn.next(); //Will right now only read one word meaning words like "ice cream" does not work - J.V
				Double price = txtIn.nextDouble();
				String sort = txtIn.next();
				testlist.add(new Product(id, name, price, sort));
				

			}
			txtIn.close();
		} catch (FileNotFoundException e) {
			// Program won't scan without an exception finder - J.V

		}

		
		while (true) {

			
			if (view.getData().equals("#2#")) {
				// kassan
				// kassan.commitSale();
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
				System.out.println("Betala: " + value);

			}

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
						addProduct(currentProduct);
						view.addProduct(currentProduct);
						
					}
				}
			}
			if (view.getData().equals("420")) {
				break;
			}
		}

		for (int i = 0; i < kvittoList.size(); i++) {
			System.out.println(kvittoList.get(i).print());
		}
		view.destroy();
	}

	public void addProduct(Product p) {
		productList.add(p);
		kvittoList.get(saleCount).addLine(p);
	}

	public double printSum() {
		snail = new Sale(productList);
	//	System.out.println(snail.getSubTotal(productList) + "SNAIL");
		return snail.getSubTotal(productList);
	}

	public List commitSale() {
		// TRANSAKTION
		// add sale to sale report system, remove product from lager, and add to ~
		// salereport. ~
		snail = new Sale(productList);

		productList = new ArrayList<Product>();
		kvittoList.add(new Receipt());

		saleCount++;
		// return kvitto;
		return kvittoList;
	}

}