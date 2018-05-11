package com.ex.strings;

public class UnderstandingStrings {
	
	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		
		String c = new String("hello");
		String d = new String("hello");
		System.out.println(d == c);
		System.out.println(d.equals(c));
		
		
		System.out.println("Hello" + "hello" == "Hello" + "hello") ;
		
		
		c = c.concat("test").toUpperCase();
		System.out.println(c);
		
		StringBuilder build = 
				new StringBuilder("hello");
		build.append("test").reverse();
		System.out.println(build);
		
		String str = build.toString();
	}

}
