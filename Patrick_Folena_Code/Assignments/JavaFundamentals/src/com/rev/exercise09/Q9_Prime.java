package com.rev.exercise09;

import java.util.ArrayList;

public class Q9_Prime {

	public static void main(String[] args)
	{
		ArrayList<Integer> prime = new ArrayList<Integer>();
		Q9_Prime main = new Q9_Prime();
		
		for(int i = 2; i <= 1000; i++)
		{
			if(main.isAPrime(i))
			{
				prime.add(i);
			}
		}
		System.out.println(prime.toString());
	}
	
	public boolean isAPrime(int check)
	{
		double upperLimit = Math.sqrt(check);
		
		if(check <= 1)
		{
			return false;
		}
		
		for(int i = 2; i <= upperLimit; i++)
		{
			if(check%i == 0)
				return false;
		}
		return true;
	}
}
