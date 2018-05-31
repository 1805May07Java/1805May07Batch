package com.rev.week1;

public class MyString {
	
	public static String substring(String str, int idx) {
		char[] inputString = str.toCharArray();
		char[] outputString = new char[idx];
		for (int i=0; i<idx; i++) {
			outputString[i] = inputString[i];
		}
		return String.valueOf(outputString);
	}
	
	public static String reverseString(String str) {
		char[] arrayOfOutput = new char[str.length()]; //array of char to hold reversed String
		char[] arrayOfInput = str.toCharArray(); //array of char of input string
		int length = arrayOfInput.length;
		for(int i=0; i<length; i++) {
			arrayOfOutput[i] = arrayOfInput[length - 1 - i]; //set the output array using the input array indexed from
															 //the right
		}
		return String.valueOf(arrayOfOutput);
	}	
	public static boolean isPalindrome(String str) {
	    char front, end;
	    boolean check = true;
	    for (int i=0; i<str.length()/2; i++) {
	        front = str.charAt(i);
	        end = str.charAt(str.length() - i - 1);
	        if (front != end) {
	            check = false;
	        }
	    }
	    return check;
	}
}
