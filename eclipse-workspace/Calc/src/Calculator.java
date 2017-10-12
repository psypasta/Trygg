
public class Calculator {

	private double a, b, result;
	
	public Calculator() {
		a = 0;
		b = 0;
		result = 0;
	}
	
	public void calculate(int decision) {
		switch(decision) {
		case 1:
			result = a + b;
			break;
		case 2:
			result = a - b;
			break;
		case 3: 
			result = a * b;
			break;
		case 4:
			if(b == 0) throw new IllegalArgumentException("Can't divide by 0!");
			result = a / b;
			break;
		}
	}
	
	public void setData(double valA, double valB) {
		a = valA;
		b = valB;
	}
	
	public double getResult() {
		return result;
	}
	
}
