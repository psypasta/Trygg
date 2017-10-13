package modig;

public class Reader {
	
	
	public static void main(String[] args) {
		/*
		// int has a width of 32
		int myMinValue = -2_147_483_648;
		int myMaxValue = 2_147_483_647;
		int myTotal = (myMinValue/2);
		System.out.println("myTotal = " + myTotal);
		
		// Byte has a width of 8
		byte myByteValue = -128;
		byte myNewByteValue = (byte) (myByteValue/2);
		System.out.println("myNewByteValue = " + myNewByteValue);
		
		// short has a width of 16
		short myShortValue = 32767;
		short myNewShortValue = (short) (myShortValue/2);
		System.out.println("myNewShortValue = " + myNewByteValue);
		
		// long has a width of 64
		long myLongValue = 9_223_372_036_854_775_807L;
		*/
		
		byte anyValidByteNumber = 10;
		short anyValidShortNumber = 20;
		int anyInt = 50;
		
		long variableLong = 50000L + 10L * (anyValidByteNumber + anyValidShortNumber + anyInt);
		System.out.println(variableLong);
		
		
	}

}
