package com.rev.question5;

import java.util.Scanner;

//Question 5: Write a substring method that accepts
//a string str and an integer idx and returns the substring 
//contained between 0 and idx-1 inclusive.  Do NOT use any of 
//the existing substring methods in the String, StringBuilder, or StringBuffer APIs.

public class Substring {
	public static void main(String[] args) {
		//initialize variables
		Scanner keyboard = new Scanner(System.in);
		
		//prompt user for string and index
		System.out.print("Enter your string: ");
		String str = keyboard.nextLine();
		System.out.print("Enter an integer index: ");
		int index = keyboard.nextInt();
		
		//execute the method
		String substring = substringThis(str, index);
		
		//print the resulting substring
		System.out.println("The resulting substring is " + substring + ".");
	}
	
	public static String substringThis(String str, int index ) {
		String tempStr = "";
		
		for(int i = 0; i < index ; i++) {
			tempStr += str.charAt(i);
		}
		
		return tempStr;
	}
}
