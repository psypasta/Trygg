package modig;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  Välkommen till den jobbiga filen.
 *  Här välkomnar vi misstag!
 *  
 *  Innehåller lösningar till project Euler problem 
 *  Lösningar sorterade med //ID* kommentarer
 *  
 *  Två delar till detta, hjälp metoder och main metoden.
 *  Koden börjar bli väldigt lång.
 *  
 *  Author: fulsomenko
 */


public class Euler {

	public static void main(String[] args) {
		
		//Array att lagra fibonacci sekvens i, ID2
		int size = 32;
		long[] fSeq = new long[size];
		
		//Multipliers for ID1
		int mulA = 5;
		int mulB = 3;	
		
		//Arraylist for ID3
		ArrayList<Long> factors;
		
		
		//Print for ID1
		System.out.println("Sum of multiples " + mulA + " and " + mulB + ": " + sumMultiples(mulA,mulB,size));
	
		//Print for ID2
		fSeq = fibSeq(size);
		System.out.println("Sum of even fib seq " + size + ": " + fibSum(fSeq));
		
		//Print for ID3
		factors = prime_factors(600851475143L);
		System.out.println("Largest prime factor of 600851475143: " + factors.get(factors.size()-1));
		
		//Print for ID4
		System.out.println("Largest palindrome made from the product of two 3-digit numbers: " + palindromeProduct());
	
		//ID5
		int n = 20;
		while(true) {
			if(smallDivise(n)) {
				break;
			}
			n = n + 20;
		}
		System.out.println("Smallest number evenly divisble by 20: " + n);
		//ID5 end
		
		//ID6
		System.out.println("Sum square difference of 100 is: " + (sumSquare(100) - squareSum(100)));
		
		//ID7
		
		ArrayList<Long> primeList = new ArrayList<Long>();
		primeList = primeList(10001);
		System.out.println(primeList.size() + " prime, is: " + primeList.get(primeList.size()-1));
		
		//ID7 end
		
		//ID8
		
		int range = 13;
		String thousandN = "73167176531330624919225119674426574742355349194934" + 
							"96983520312774506326239578318016984801869478851843" + 
							"85861560789112949495459501737958331952853208805511" + 
							"12540698747158523863050715693290963295227443043557" + 
							"66896648950445244523161731856403098711121722383113" + 
							"62229893423380308135336276614282806444486645238749" + 
							"30358907296290491560440772390713810515859307960866" + 
							"70172427121883998797908792274921901699720888093776" + 
							"65727333001053367881220235421809751254540594752243" + 
							"52584907711670556013604839586446706324415722155397" + 
							"53697817977846174064955149290862569321978468622482" + 
							"83972241375657056057490261407972968652414535100474" + 
							"82166370484403199890008895243450658541227588666881" + 
							"16427171479924442928230863465674813919123162824586" + 
							"17866458359124566529476545682848912883142607690042" + 
							"24219022671055626321111109370544217506941658960408" + 
							"07198403850962455444362981230987879927244284909188" + 
							"84580156166097919133875499200524063689912560717606" + 
							"05886116467109405077541002256983155200055935729725" + 
							"71636269561882670428252483600823257530420752963450";
		
		ArrayList<String> digits = new ArrayList<String>();
		digits = sub(thousandN, range);
		
		String temp = null;
		long largest = 0;
		for(int i = 0; i < digits.size(); i++) {
			temp = sortString(digits.get(i));
			digits.set(i, temp);
			
			if(checkLong(digits.get(i)) > largest) {
				largest = checkLong(digits.get(i));
			}
			
		}
		//Pring for ID8
		System.out.println("Greatest product of " + range + " adjacent digits in sample: " + largest);
		//ID8 end
	
	}
	
	//ID8
	
	//borde inte behöva denna metoden men jag sneade, easy way out.
	public static long checkLong(String s)
	{
		long product = 1;

		for (int i = 0; i < s.length(); i++)
		{
			Character c = new Character(s.charAt(i));
			String tmp = c.toString();
			int temp = Integer.parseInt(tmp);
			product *= temp;
		}
		return product;
	}
	
	//sort string of numbers in ascending order
	public static String sortString(String s) {
		//make it string sorted because 9*9*7 greater then 7*7*7'
		//stop making this harder ^^
		int[] numbers = new int[s.length()];
		String ascending = "";
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] =  Character.getNumericValue(s.charAt(i));
		}
		Arrays.sort(numbers);
		for(int i = 0; i < numbers.length; i++) {
			ascending += numbers[i];
		}
		return ascending;
	}
	// return long arraylist?
	public static ArrayList<String> sub(String s, int range){
		ArrayList<String> digits = new ArrayList<String>();
		String n = null;
		for(int i = 0; i < (s.length() - (range-1)); i++) {			
			n = s.substring(range-range+i, range+i);
			digits.add(n);
		}
		return digits;
	}
	
	public static int maxN(int[] n) {
		 int max = n[0];
	        for (int i = 1; i < n.length; i++){
	        	if (n[i] > max){
	        		max = n[i];
	        	}
	        }        
		return max;
	}
	
	//ID8 END
	
	//ID 6
	
	public static int squareSum(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += (i*i);
		}
		return sum;
	}
	
	public static int sumSquare(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return (sum*sum);
	}
	
	//ID 6 end

	//ID 5
	
	public static boolean smallDivise(int number) {
		int smallNumber = 2520;
		
		for(int i = 1; i < 21; i++) {
			if(number % i != 0) {
				return false;
			}
		}
		return true;
	}

	//ID 5 end
	
	
	//ID 4
	
	public static int palindromeProduct() {
		
		int maxPalin = -1;
		
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				int prod = i * j;
				if (isPalindrome(prod) && prod > maxPalin)
					maxPalin = prod;
			}
		}
		return maxPalin;
	}

	
	//ID4 end
	
	// Project euler ID 3 
	
	public static boolean isPalindrome(int a) {
		String value = null;
		value = value.valueOf(a);
	
		int n = value.length();
		  for (int i = 0; i < (n/2); ++i) {
		     if (value.charAt(i) != value.charAt(n - i - 1)) {
		         return false;
		     }
		  }
		  
		  return true;
	}

	public static ArrayList<Long> prime_factors(long n) {

		ArrayList<Long> factors = new ArrayList<Long>(1);
		long d = 2;
		
		while(n > 1) {
			while(n % d == 0) {
				if(isPrime(d)) {
					factors.add(d);
				}
				n = n / d;
			}
			d = d + 1;
		}
			
		return factors;
	}
	
	//ID7 Begin
	
	public static ArrayList<Long> primeList(int n){
		ArrayList<Long> list = new ArrayList<Long>();
		int i = 0;
		
		while(list.size() < 10001) {			
			if(isPrime(i)) {
				list.add((long) i);
			}
			i = i+1;
		}
		return list;
	}
	
	//ID7 end
	
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
			
			c = b;
			b = a + b;
			a = c;
		}
		
		return fS;
	}
	//ID 2 end
	
	//ID 1
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
	//ID 1 end
}
