package registerSystem;

import gui.Test;

public class Main {

	public static void main(String[] args) {
		
		
		Test test = new Test();
		test.run();

		Register /*HASSAN TILL*/kassan = new Register();
		Product produces = new Product(1210, "Marabou stek choklad", 100);
		
		while(true) {
			
		//	System.out.println(test.getData());
			if(test.getData().equals("00")) {
				System.out.println();
				System.out.println("SEPE");
				break;	
			}
			else if(test.getData().equals("10")) {
				test.setData();
				System.out.println("choklad");
				kassan.addProduct(produces);
			}
			System.out.println(test.getData());
		}
		
		kassan.commitSale();
		test.destroy();
	}

}
