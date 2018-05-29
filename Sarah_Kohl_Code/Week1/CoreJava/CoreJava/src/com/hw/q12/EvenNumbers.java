package com.hw.q12;

import java.util.ArrayList;

public class EvenNumbers {

	public static ArrayList<Integer> evenNumbers(ArrayList<Integer> numbers)
	{
		ArrayList<Integer> evens = new ArrayList<Integer>();
		
		for(int number : numbers)
		{
			if(number%2 == 0)
			{
				evens.add(number);
			}
		}
		
		return evens;
	}
	
	public static void printEvens(ArrayList<Integer> numbers)
	{
		ArrayList<Integer> evens = evenNumbers(numbers);
		for(int number : evens)
		{
			System.out.println(number);
		}
		
	}
}
