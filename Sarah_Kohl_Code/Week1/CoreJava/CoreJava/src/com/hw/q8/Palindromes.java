package com.hw.q8;

import java.util.ArrayList;

public class Palindromes {
	
	
	
	private static boolean isPalindrome(String word)
	{
		for(int fromEnds = 0 ; fromEnds <word.length()/2 ; fromEnds++)
		{
			if(word.charAt(fromEnds) != (word.charAt(word.length()-1-fromEnds)))
			{
				return false;
			}
		}
			return true;
	}
	
	public static ArrayList<String> palindromes(ArrayList<String> words) {
		
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String word : words) {
			if(isPalindrome(word))
			{
				palindromes.add(word);
			}
		}
		return palindromes;
	}

}
