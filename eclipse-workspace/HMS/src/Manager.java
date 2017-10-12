

public class Manager extends Staff {

	public int hotelBudget = 1000;

	//s är namn och n är ID
	public Manager(String s, int n) {
		name = s;
		id = n;
	}
	
	public Water[] purchaseWater(int n) {
		Water[] waterStock = new Water[n];
		for(int i = 0; i < waterStock.length; i++) {
			waterStock[i] = new Water(i);
			hotelBudget = hotelBudget - waterStock[i].cost;
		}
		return waterStock;
		
	}
	public Pizza[] purchasePizza(int n) {
		Pizza[] pizzaStock = new Pizza[n];
		for(int i = 0; i < pizzaStock.length; i++) {
			pizzaStock[i] = new Pizza(i);
			hotelBudget = hotelBudget - pizzaStock[i].cost;
		}	
		return pizzaStock;
	}
	
	int getHotelBudget(){
		return hotelBudget;
	}
}
