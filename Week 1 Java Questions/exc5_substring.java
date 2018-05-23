package com.rev.questions;

public class exc5_substring {
	//Write a substring method that accepts a string str and an integer idx and returns the substring 
	//contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the 
	//String, StringBuilder, or StringBuffer APIs.
	
	public String sub(String str, int idx) {
		
		String str2 = "";
		for (int i = 0; i < idx; i++) {
			str2+= str.charAt(i);
		}
		return str2;
	}
}
