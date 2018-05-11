package com.revhomework.Question5;

public class BadSubstring 
{
	public static void main(String[] args) 
	{
		BadSubstring tester = new BadSubstring();
		String test1 = "New to testing this maddness";
		System.out.println(tester.badSubber(test1, 6));
		
	}
	
	
	public String badSubber(String str, int idx) 
	{ 
		// string we are out putting
		String output = "";
		
		//checks that it is a valid position
		if(idx < str.length()) 
		{
			//create the new variable
			for(int i = 0; i <= idx; i++) 
			{
				output += str.charAt(i);
			}
		}
		else 
		{
			//return an error message.
			return "That is not a valid position, on the string";
		}
		
		
		return output;
	}
	
	
}
