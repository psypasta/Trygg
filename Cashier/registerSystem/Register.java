package registerSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adminSystem.User;
import gui.Test;
import registerSystem.Product.Category;

public class Register {
	//Lägga till gånger antal istället för att skriva in samma vara flera gånger.
	//product count
	private int productCount = 0;
	private int saleCount = 0;
	private double saldo = 2550;
	private double price = 0;
	
	private Test view = new Test();
	
	private Product produces = new Product(1210, "Marabou stek choklad", 100.0);
	
	private List <Product> productList = new ArrayList<Product>();
	private List<Receipt> kvittoList = new ArrayList<Receipt>();
//	List<Sale> salesList = new ArrayList<Sale>();
	private Sale snail;
//	private Receipt kvitto;
	private Sale s = new Sale(productList);
	private File matFile = new File("Cashier/resource/mat.txt");
	
	
	private User user;
	
	public Register(User u, List productList, Test view) {
		this.user = u;
		this.productList = productList;
		this.view = view;
		
		view.run();
		kvittoList.add(new Receipt());
	}
	
	public void run() {
		
		while(true) {
			
		//	System.out.println(test.getData());
			if(view.getData().equals("#2#")) {
	//			kassan
		//		kassan.commitSale();
				view.setData();
				price = printSum();
				
				System.out.println("Betala: " + price);
				
				
			}
			else if(view.getData().equals("10")) {
				view.setData();
				System.out.println("choklad");
				addProduct(produces);
				view.addProduct(produces);
			}
			else if (view.getData().equals("00")) {
				view.setData();
				kvittoList = commitSale();
				view.clearArea();
			}
			if(view.getData().equals("420")) {
				break;
			}
		//	System.out.println(test.getData());
		}
		
		for(int i = 0; i < kvittoList.size(); i++) {
	//		System.out.println(receiptList.size());
			System.out.println(kvittoList.get(i).getData());
		}
		
		view.destroy();
		
	}
	
	public void addProduct(Product p) {
		productList.add(p);
		kvittoList.get(saleCount).addLine(p);
	}
	
	public double printSum() {
		snail = new Sale(productList);
	//	price = 
		System.out.println(snail.getSubTotal(productList) + "SNAIL");
		return snail.getSubTotal(productList);
	}
		
	public List commitSale() {
		//TRANSAKTION
		//add sale to sale report system, remove product from lager, and add to ~ salereport. ~ 
		snail = new Sale(productList);
		
		productList = new ArrayList<Product>();
		kvittoList.add(new Receipt());
		
		saleCount++;
	//	return kvitto;
		return kvittoList;
	}
	
}