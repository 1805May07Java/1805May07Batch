package com.rev.exercise05;

public class Q5_Substring {
	public static void main(String[] args)
	{
		Q5_Substring control = new Q5_Substring();
		System.out.println(control.subString(args[0], 0, Integer.parseInt(args[1])-1));
	}
	
	public String subString(String str, int firstIndex, int lastIndex)
	{
		if(firstIndex > lastIndex || firstIndex > str.length())
		{
			return "";	//Unsure, look up substring behavior. Know error gets thrown with 2nd situation.
		}
		else if (lastIndex > str.length())
		{
			return "";
		}
		else
		{
			String output = "";
			for(int i = firstIndex; i <= lastIndex; i++)
			{
				output += str.charAt(i);
			}
			return output;
		}
	}
}
