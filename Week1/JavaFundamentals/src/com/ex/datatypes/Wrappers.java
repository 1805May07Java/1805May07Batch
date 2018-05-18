package com.ex.datatypes;

import java.util.Arrays;
import java.util.Scanner;

public class Wrappers {
	// primitives
		/* 
		 * int - 4 bytes - Integer
		 * char - 2 bytes - Character
		 * boolean - ? - Boolean
		 * double - 8 bytes - Double
		 * long - 8 bytes - Long
		 * float - 4 bytes - Float
		 * short - 2 bytes - Short
		 * byte - 1 byte - Byte
		 */
		public static void main(String[] args) {
			// comparingPrimitivesAndWrappers();
			// parsing();
			overloading();
		}
		/*
		 * When overloading, the compiler or the jvm has an order it follows
		 * 1. Exact Match
		 * 2. Implicit Casting (type conversion)
		 * 3. Auto-Boxing
		 * 4. VarArgs
		 */
		private static void overloading() {
			int intPrimitive = 5;
			Integer intObject = 5; // new Integer(5);
			
			short shortPrimitive = 5;
			Short shortObject = 5;
			
			long longPrimitive = 5;
			Long longObject = 5l;
			
			float floatPrimitive = 5;
			Float floatObject = 5.0f;
			
			double doublePrimitive = 5;
			Double doubleObject = 5.0;
			method(intPrimitive);
			method(shortPrimitive);
			method(intPrimitive, longPrimitive);
			method(intPrimitive, longObject);
			// method(shortPrimitive, longPrimitive);
			method(5, 5);
			method(5,5,6,7,8,4,5);
			
		}
		
		public static void method(int x) {
			System.out.println("primitive int passed: "+ x);
		}
		public static void method(Short x) {
			System.out.println("object Short passed: "+ x);
		}
		public static void method(Integer x, long y) {
			System.out.println("Object Integer and primitive long passed: "+ x + " " + y);
		}
		public static void method(int... x) {
			System.out.println("varargs int passed: "+Arrays.toString(x));
		}

		private static void parsing() {
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			
			Double d = Double.parseDouble(s);
			System.out.println(d);
		}

		private static void comparingPrimitivesAndWrappers() {
			int intPrimitive = 5;
			Integer intObject = 5; // new Integer(5);
			
			short shortPrimitive = 5;
			Short shortObject = 5;
			
			long longPrimitive = 5;
			Long longObject = 5l;
			
			float floatPrimitive = 5;
			Float floatObject = 5.0f;
			
			double doublePrimitive = 5;
			Double doubleObject = 5.0;
			
			// automatically unwrap (auto-unbox) the object to a primitive type.
			System.out.println("intPrimitive == intObject: "+ (intPrimitive == intObject));
			
			// comparing memory locations of two objects
			System.out.println("intObject == new Integer(5): "+(intObject == new Integer(5)));
			
			// compare values and types of two objects
			System.out.println("intObject.equals(new Integer(5)): "+(intObject.equals(new Integer(5))));
			// auto-box 5 to Integer
			System.out.println("intObject.equals(5): "+intObject.equals(5));
			
			// primitives compares value, order doesn't matter
			System.out.println("intPrimitive == shortPrimitive: "+(intPrimitive==shortPrimitive));
			System.out.println("shortPrimitive == intPrimitive: "+(shortPrimitive==intPrimitive));
			
			// cannot compare two different object types
			System.out.println("longObject.equals(intObject): "+(longObject.equals(intObject)));
			// retrieve the value from the wrapper
			System.out.println("longObject.equals(intObject): "+(longObject.equals(intObject.longValue())));
		}
}
