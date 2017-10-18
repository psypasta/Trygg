package modig;

import java.util.ArrayList;

public class Euler {

	public static void main(String[] args) {
		
		//Array att lagra fibonacci sekvens i ID2
		int size = 32;
		long[] fSeq = new long[size];
		
		//Multipliers för ID1
		int mulA = 5;
		int mulB = 3;	
		
		
		//Print för ID1
		System.out.println("Sum of multiples " + mulA + " and " + mulB + ": " + sumMultiples(mulA,mulB,size));
	
		//Print för ID2
		System.out.println("Fibonacci sequence " + size + ": ");
		fSeq = fibSeq(size);
		System.out.println("Sum of even fib seq " + size + ": " + fibSum(fSeq));
		
		//ID3
		prime_factors(600851475143L);
	
		//ID4
		System.out.println(palindromeProduct());
		
	}
	
	//ID 4
	
	public static int palindromeProduct() {
		
		int maxPalin = -1;
		
		for(int i = 100; i < 1000; i++) {
			for(int j = 100; j > 1000; j++) {
				int prod = i * j;
				if(isPalindrome(prod) && prod > maxPalin) {
					maxPalin = prod;
				}
			}	
		}
		return maxPalin;
	}
	
	public static boolean isPalindrome(int a) {
		String value = null;
		value = value.valueOf(a);
		
		System.out.println("wot");
	
		int n = value.length();
		  for (int i = 0; i < (n/2); ++i) {
		     if (value.charAt(i) != value.charAt(n - i - 1)) {
		         return false;
		     }
		  }
		  
		  return true;
	}
	
	//ID4 end
	
	// Project euler ID 3 
	
	public static ArrayList<Long> prime_factors(long n) {

		ArrayList<Long> factors = new ArrayList<Long>(1);
		long d = 2;
		
		while(n > 1) {
			while(n % d == 0) {
				if(isPrime(d)) {
					factors.add(d);
					System.out.println(d);
				}
				n = n / d;
			}
			d = d + 1;
		}
			
		return factors;
	}
	
	public static boolean isPrime(long n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	// Project euler ID 3 end
	
	// Project euler ID 2

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
		//	System.out.println(fS[i] + " " + "loop: " + i);
			
			c = b;
			b = a + b;
			a = c;
		}
		
		return fS;
	}
	
	// // Project euler ID 2 end
	
	// Project euler ID 1
	
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
	
	// Project euler ID 1 end
}
