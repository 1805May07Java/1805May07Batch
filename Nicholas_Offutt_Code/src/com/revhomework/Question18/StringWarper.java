package com.revhomework.Question18;

public class StringWarper extends StringActor {

	@Override
	boolean checkUpper(String str) 
	{
				//set up the char array of Capitals
				String checker = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				char[] hold = new char[1];
				
				
				//check each letter of the string against all capitals
				for(int i = 0; i < checker.length(); i++) 
				{
					//return true if we find any capitals
					hold[0] = checker.charAt(i);
					String checking = new String(hold);
					if (str.contains(checking)) 
					{
						return true;
					}

				}
		
		return false;
	}

	@Override
	String makeLower(String str) 
	{
		//returns a lower cased string
		return str.toLowerCase();
	}

	@Override
	int makeNumber(String str) 
	{
		int output = 0;
		
		//turns each letter in a string into a numeric value
		for(int i=0; i < str.length(); i++)
		{
			output += str.codePointAt(i);
		}
		
		//returns output plus 10
		return output + 10;
	}

}
