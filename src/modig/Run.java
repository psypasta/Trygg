package modig;

public class Run {

	public static void main(String[] args) {
		Test yolo = new Test();
		Test robin = new Test(1,2,3);
		
		int[] test = new int [3];
		
		test = yolo.getVal();
		
		for(int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
		
		test = robin.getVal();
		
		for(int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}

	}

}
