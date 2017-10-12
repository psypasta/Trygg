
public class Hotel {
	public static void main(String args[]) {
		
		boolean running = true;
		
		while(running) {
			running = false; // <------ OM WTF ÄR DETTA
		
			Manager hotelManager = new Manager("Henke", 0);
			Food[] water = hotelManager.purchaseWater(50);
			Food[] pizza = hotelManager.purchasePizza(50);
			System.out.println("Budget: " + hotelManager.getHotelBudget());
		}
		
		
	
	}
}