package com.rev.exercises;

import java.util.Scanner;

public class ReverseString 
{
	
	public static void main(String[] args) 
	{
		String a;
		char[] b;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter a string.");
		a = in.nextLine();
		b = a.toCharArray();
		
		for(int i = b.length-1; i >= 0; i--)
		{
			System.out.print(b[i]);
			
		}
		
	}
	
}
