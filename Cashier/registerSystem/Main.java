package registerSystem;

import gui.Test;

public class Main {

	public static void main(String[] args) {
		Test test = new Test();
		test.run();

		Register /*HASSAN TILL*/kassan = new Register();
		
		while(true) {
		
			Product produces = new Product(1210, "Marabou stek choklad", 100);
			//kassan.addProduct();
			kassan.addProduct(produces);
		//	System.out.println(test.getData());
			if(test.getData() == "00") {
				break;
			}
			
		}
		kassan.commitSale();
	}

}
