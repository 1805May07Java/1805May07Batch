package com.rev.exercise03;

public class Q3_StringReversal {
	public static void main(String[] args)
	{
		Q3_StringReversal control = new Q3_StringReversal();
		
		System.out.println(control.reverseString(args[0]));
	}
	
	public String reverseString(String originalString)
	{
		if(originalString == null)
		{
			return "String is Null";
		}
		String reverse = "";
		for(int i = originalString.length() - 1; i >= 0; i--)
		{
			reverse += originalString.charAt(i);
		}
		return reverse;
	}
}
