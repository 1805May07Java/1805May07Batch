package com.rev.exercise08;

import java.util.ArrayList;

public class Q8_Palindrome 
{
	public static void main(String[] args)
	{
		Q8_Palindrome main = new Q8_Palindrome();
		
		ArrayList<String> allWords = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String arg : args)
		{
			allWords.add(arg);
			if(main.isAPalindrome(arg)) {
				palindromes.add(arg);
			}
		}
		
		System.out.println(allWords.toString());
		System.out.println(palindromes.toString());
	}
	
	public boolean isAPalindrome(String check)
	{
		for(int i = 0; i < check.length()/2; i++)
		{
			if(check.charAt(i) != check.charAt(check.length()-i-1))
				return false;
		}
		return true;
	}
}
