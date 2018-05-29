package com.hw.q5;

public class SubString {
	
	static String getSubStringFromZeroTo(String str, int idx)
	{
		StringBuilder s = new StringBuilder();
		
		if(idx > str.length()-1 || idx < 1)
		{
			throw new IndexOutOfBoundsException();
		}
		
		for(int i = 0; i<=idx-1 ; i++)
		{
			s.append(str.charAt(i));
		}
		
		return s.toString();
	}

}
