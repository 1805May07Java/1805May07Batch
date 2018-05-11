package com.rev.reverse;

public class ReverseString
{
   public void reverseWordInMyString(String str)
   {
	
	String[] words = str.split(" ");
	String reversedString = "";
	//Loop through words and reverse character order
	for (int i = 0; i < words.length; i++)
        {
           String word = words[i]; 
           String reverseWord = "";
           for (int j = word.length()-1; j >= 0; j--) 
	   {
	
		reverseWord = reverseWord + word.charAt(j);
	   }
	   reversedString = reversedString + reverseWord + " ";
	}
	//Print original string and then reversed string
	System.out.println(str);
	System.out.println(reversedString);
   }
   public static void main(String[] args) 
   {
	ReverseString obj = new ReverseString();
	obj.reverseWordInMyString("I am about to reverse this string");
	obj.reverseWordInMyString("The string has been reversed");
   }
}