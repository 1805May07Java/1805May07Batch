package com.ex.datatypes;

public class Primatives {
	//int, long, short, byte, double, float, boolean, char
	
	public static void main(String[] args) {
		long lon = 81781367261L;
		
		int millions = 1_000_000;
		double test = 4.5_12;
		
		int thisIsCamelCase = 90;
		final int CONST;
		CONST = 6;
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		//HEX = 0-9, a-f
		int hex = 0x9ea3;
		int h2 = 0X8ADB;
		int h3 = 0x7Ab2C;
		
		//BINARY
		int bin = 0b10101;
		int b = 1010101011;
		
		//OCTAL - 0-7 - base 8
		int oct = 0167;
		
		System.out.println(hex);
		
		//CASTING VS AUTOBOXING
		Integer integer = new Integer(10);
		int x = integer;
		
		Integer i2 = x + 10; 				//autoboxing
		
		////////////////////
		int small = 10;
		short sh = (short)small;	//Explicit, cast with possible bad results 
		long lo = small;			//Implicit
		
		//char, short, byte --> int --> long
		//floats/double
		//boolean
		
		char ch = 'x';
		char c = 127;
		System.out.println(c);
		
		double doub = small;
		
		float flo = small;
		
		
		System.out.println(small / 3);
		System.out.println(doub / 3);
		System.out.println(flo/3);
	}
}
