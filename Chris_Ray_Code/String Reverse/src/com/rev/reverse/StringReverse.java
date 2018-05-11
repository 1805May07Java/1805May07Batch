package com.rev.reverse;

//import java.util.*;

public class StringReverse {

	public static void main(String[] args) {
		
		System.out.println(reverseString("aaabbb"));

	}
	
	public static String reverseString(String s1) {
		char[]s2 = s1.toCharArray();
		char[]s3 = new char[s2.length];
		for(int i = 0; i < s2.length; i++) {
			s3[i] = s2[s2.length-1-i];
		}
		
		String reversedString = new String(s3);
		return reversedString;
	}
	
}
