package modig;

public class Test {
	private int a, b ,c, d, e , f = 0;
	//private int d, e , f = 0; 
	
	
	public Test() {
		
	}
	
	public Test(int valA, int valB, int valC, int valD, int valE, int valF) {
		a = valA;
		b = valB;
		c = valC;
		d = valD;
		e = valE;
		f = valF;
	}
	
	public int[] getVal() {
		
		int[] temp;
		temp = new int[6];
		temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		temp[3] = d;
		temp[4] = e;
		temp[5] = f;
		
		
		return temp;
	}
}
