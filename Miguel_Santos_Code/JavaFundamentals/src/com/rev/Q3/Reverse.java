package com.rev.Q3;

public class Reverse {
	
	public static void main(String[] args) {
		System.out.println(Reverse.ReverseStr("My name is Miguel"));
	}

	public static String ReverseStr(String s) {
		
		int len = s.length();
		for(int i = 0; i < len; i++) {
			s += s.substring(len-i-1, len-i);
		}
		
		s = s.substring(len, s.length());
		
		return s;
	}
	
}
