package modig;

public class Test {
	private int a, b ,c = 0;
	
	
	public Test() {
		
	}
	
	public Test(int valA, int valB, int valC) {
		a = valA;
		b = valB;
		c = valC;
	}
	
	public int[] getVal() {
		
		int[] temp;
		temp = new int[3];
		
		temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		
		return temp;
	}
}
