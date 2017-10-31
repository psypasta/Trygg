package Cashier;

public class Main {

	public static void main(String[] args) {
		Product produces = new Product(0, "Marabou stek choklad", 100);
		System.out.println(produces.getID());
		System.out.println(produces.getPrice());
		System.out.println(produces.getProductName());
		
		Register kassan = new Register();
		kassan.addProduct();
		
	}

}
