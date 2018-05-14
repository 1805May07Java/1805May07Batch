package com.ex.datatypes;

import static java.lang.Math.*;

public class Primitives {
	//int, long, short, byte, double, float, boolean, char
	
	public static void main(String[] args) {
		/*
		 * when a number is present in code, it is called a 
		 * literal. By default, Java assumes you are defining
		 * an int value with a whole number literal. In the 
		 * following example. 98323559823 is out of range for an
		 * int, so we get a compiler error when trying to declare
		 * it without the L signifier. 
		 */
		//long wronglong = 98_323_559_823; // does not compile
		long rightlong = 98323559823L;
		
		//cannot use commas for separation of digits but can use _
				//underscores have to be located within digits
				int commas = 1_000_000_000;
				//int wrong = _100;
				//int alsowrong = 100_;
				//double doublewrong = 10_._0_;
		int millions = 1_000_000;
		double test = 4.5_12;
		
		int $0 = 78;
		
		int thisIsCamelCase = 90;
		final int CONST;
		CONST = 6;
		
		System.out.println(Integer.MAX_VALUE); // 2147483647
		System.out.println(Integer.MIN_VALUE); //-2147483648
		
		
		//HEX = 0-9, a-f
		int hex = 0x9ea3; //40611
		int h2 =  0X8ADB;
		int h3 = 0x7Ab2C;
		int h4 = 20193;
		
		//BINARY 
		int bin = 0b10101;
		int b = 1010101011;

		//OCTAL - 0-7 - base 8
		int oct = 0167;

		System.out.println(hex);
		
		//CASTING VS AUTOBOXING
		Integer integer = new Integer(10);
		int x = integer;
		
		Integer i2 = x + 10;
		
		
		
		//////////
		int small = 10;
		short sh = (short) small; //explicit
		long lo = small;//implicit
		
		
		//char, short, byte --> int --> long
		//floats/double
		//boolean
		
		char ch = 'x';
		char c = 127;
		System.out.println(c);
		
		double doub = small;
		doub = 10;
		
		System.out.println(3/4);
		System.out.println(doub/3);
		
		//importing static method sqrt from Math class
		double sq = sqrt(doub);
		System.out.println(sq);
		
	}

}
