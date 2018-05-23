package com.rev.excersizes;

//import static java.lang.Math.*;

public class Primitives {
	public static void main(String[] args) {
		//int, long, short, byte, double, double, float, boolean, char
		
		//long lon = 86358746392879L;
		
		//int millions = 1_000_000;
		//double test = 4.5_12;
		
		//int $0 = 78;
		
		//int thisIsCamelCase = 90;
		//final int CONST;
		//CONST = 6;
		
		System.out.println(Integer.MAX_VALUE); //2147483647
		System.out.println(Integer.MIN_VALUE); //-2147483648
		
		//HEX = 0-9, a-f
		int hex = 0x9ea3; //40611
		//int h2 = 0x8ADB;
		//int h3 = 0x7Ab2C;
		
		//Binary
		//int bin = 0b10101;
		//int b = 1010101011;
		
		//Octal = 0-7 - base 8
		//int oct = 0167;
		
		System.out.println(hex);
		
		//Casting vs Autoboxing
		//Integer integer = new Integer(10);
		//int x = integer;
		
		//Integer i2 = x + 10;
		
		
		//////////
		int small = 10;
		//short sh = (short) small; //explicit casting
		//long lo = small; //implicit casting
		
		
		//char, short, byte --> int --> long
		//float/double
		//boolean
		
		//char ch = 'x';
		char c = 120;
		System.out.println(c);
		
		double doub = small;
		doub = 10;
		
		System.out.println(small/3);
		System.out.println(doub/3);
		
		//importing static method sqrt from math class
		//double sqrt = sqrt(doub);
	}
}
