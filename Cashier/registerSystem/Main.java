package registerSystem;

public class Main {

	public static void main(String[] args) {
		Product produces = new Product(1210, "Marabou stek choklad", 100);
		Product produces2= new Product(1337, "NoccoNIPMelon", 20000);
		Register kassan = new Register();
		//kassan.addProduct();
		kassan.addProduct(produces);
		kassan.addProduct(produces2);
		kassan.commitSale();
	}

}
