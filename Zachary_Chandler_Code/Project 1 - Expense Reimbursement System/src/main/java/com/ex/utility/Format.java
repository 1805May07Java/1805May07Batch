package com.ex.utility;

public class Format {

	public static String name(String value) {
		StringBuilder result = new StringBuilder();
		
		result.append(value.toLowerCase());
		result.setCharAt(0, Character.toUpperCase(value.charAt(0)));
		
		return result.toString();
	}
}
