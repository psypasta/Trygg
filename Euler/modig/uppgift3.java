package modig;

import java.util.ArrayList;

public class uppgift3 {

	public static void main(String[] args)
	{
		long prime = 13195;
		long divider = 2;
		ArrayList<Long> factor = new ArrayList();
		
		
		while(prime > 1)
		{
			while(prime % divider == 0)
			{	
				
				prime = prime / divider;
				factor.add(divider);	
				
				
				
			}
			
			
			divider++;
			
		}
	
	
		System.out.println(factor.get(factor.size() -1 ));
		
	}
	
	
}
