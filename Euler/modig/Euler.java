package modig;

public class Euler {

	public static void main(String[] args) {
		int size = 10;
		int[] fSeq = new int[size];
		
	   System.out.println("%d\n" + sumMultiples(5,3,10));
		
	   fSeq = fibSeq(size);
		
		
	
	}
	
	public static int[] fibSeq(int r) {
		
		int [] fS = new int[r];
		
		int a,b,c = 0;	
		
		a = 1;
		b = 1;
		
		for(int i = 0; i < r; i++) {
			
			
			fS[i] = b;
			System.out.println(fS[i]);
			
			c = b;
			b = a + b;
			a = c;
			
			
		}
		
		return null;
	}
	
	public static int sumMultiples(int a, int b, int r) {
		int i,sum=0;
	    
	    for(i=0;i<r;i++)
	    {
	        if((i%a==0)||(i%b==0))
	        {
	            sum=sum+i;
	        }
	    }
		return sum;
	}
}
