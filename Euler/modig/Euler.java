package modig;

public class Euler {

	public static void main(String[] args) {
		int size = 32;
		long[] fSeq = new long[size];
		
		int mulA = 5;
		int mulB = 3;		
		
		System.out.println("Sum of multiples " + mulA + " and " + mulB + ": " + sumMultiples(mulA,mulB,size));
	
		System.out.println("Fibonacci sequence " + size + ": ");
		fSeq = fibSeq(size);
		System.out.println(fibSum(fSeq));
		
		
	}
	
	public static long fibSum(long[] fS){
		long sum = 0;
		
		for(int i = 0; i < fS.length; i++) {
			if (fS[i]%2 ==0) {
				sum = sum + fS[i];
			}
		}
		
		return sum;
	}
	
	public static long[] fibSeq(int r) {
		
		long [] fS = new long[r];
		
		long a,b,c = 0;	
		
		a = 1;
		b = 1;
		
		for(int i = 0; i < r; i++) {
			
			
			fS[i] = b;
			System.out.println(fS[i] + " " + "loop: " + i);
			
			c = b;
			b = a + b;
			a = c;
			
			
		}
		
		return fS;
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
