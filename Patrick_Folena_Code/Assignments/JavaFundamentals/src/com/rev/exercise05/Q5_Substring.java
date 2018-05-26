package com.rev.exercise05;

public class Q5_Substring {
	public static void main(String[] args)
	{
		Q5_Substring control = new Q5_Substring();
		System.out.println(control.subString(args[0], 0, Integer.parseInt(args[1])-1));
	}
	
	public String subString(String str, int firstIndex, int lastIndex)
	{
		if(str.length() == 0)
		{
			return "";
		}
		
		try
		{
			if(firstIndex > lastIndex)
			{
				int temp = firstIndex;
				firstIndex = lastIndex;
				lastIndex = temp;
			}
			
			String output = "";
			for(int i = firstIndex; i <= lastIndex; i++)
			{
				output += str.charAt(i);
			}
			return output;
		}catch(StringIndexOutOfBoundsException e)
		{
			return "Error: Index Out Of Bounds";
		}
	}
}
