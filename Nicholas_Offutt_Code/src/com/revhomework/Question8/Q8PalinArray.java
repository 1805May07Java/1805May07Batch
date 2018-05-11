package com.revhomework.Question8;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q8PalinArray 
{

	public static void main(String[] args) 
	{
		//our ArrayLists we are storing our data in 
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		//file path of our read file 
		String path = "src\\com\\revhomework\\Question8\\WordList.txt";
		//where we are sticking each line of the file
		String line = "";
				
			
				
		//set up the try catch block for file reading
		try 
		{
				//attempt to load the file 
				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				
				//read each line from the file
				while((line = reader.readLine()) != null) 
				{
							list.add(line);	
				}
				
				
				System.out.println("Here are the words in our list:");
				//Print out the first list
				for(String str : list) 
				{
					
					System.out.print(str.toString() + " ");
					
				}
				
				
				System.out.println();
				//hunting out the palindromes
				for(String str : list) 
				{
					if(isPalind(str.toString())) 
					{
						palindromes.add(str);
					}
				}
				
				
				System.out.println("Here are the words that are palindromes:");
				//Print out the first list
				for(String str : palindromes) 
				{
					
					System.out.print(str.toString() + " ");
				}
				
				
				
				//close reader
				reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
						
			e.printStackTrace();
		}		
		
	}
	
	
	static boolean isPalind(String str) 
	{
		// string builder so we can easy reverse
		StringBuilder reverser = new StringBuilder(str);
		
		//return the result of a comparison to the reversed string 
		return str.equals(reverser.reverse().toString());
			
	}	
	
	
	
}
