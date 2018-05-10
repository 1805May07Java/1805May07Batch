package com.rev.questions;

public class exc3_reverseString {
		
	
	public void revString(String str) {
		//Reverse a string without using a temporary variable. 
		//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
		
		for(int i = str.length()-1; i >= 0; i--) {
			System.out.print(str.charAt(i));	
		}
		
	}
}
