package com.rev.exercises;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) 
	{
		ArrayList<Integer> possibles = new ArrayList<>();
		ArrayList<Integer> primes = new ArrayList<>();
		
		for(int i = 0; i < 100; i++)
		{
			possibles.add((i+1));
		}
		
		for(int i = 2; i < 101; i++)
		{
			boolean isPrime = true;
			for(int y = 2; y < i; y++) 
			{
				if(i % y == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				primes.add(i);
			}
				
		}
		System.out.println(primes);
		
	}

}
