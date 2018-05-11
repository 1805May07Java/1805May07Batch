package com.rev.question3;
//Question 3: Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class ReverseString {
	public static void main(String[] args) {
		String str = null;
		
		//attempt to parse the string from the command line
		try{
			str = args[0];
		}catch(Exception e) {
			System.out.println("Error: enter a string");
			System.exit(0);
		}		
		
		System.out.print("The reverse of your word: '" +str+"' is '");
		String result = reverseString(str);
		System.out.println(result + "'.");
		
		
	}
	
	public static String reverseString(String str) {
		String result = "";
		
		for(int i = str.length()-1; i>-1; i--) {
			result += str.charAt(i);
		}

		return result;		
	}
}
