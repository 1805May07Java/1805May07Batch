package com.rev.exercises;

import java.util.ArrayList;

public class ArrayLists {

	public static void main(String[] args) 
	{
		ArrayList<Integer> nums = new ArrayList<>();
		int sum = 0;
		
		for(int i = 0; i < 10; i++)
		{
			nums.add(i+1);
		}
		System.out.println(nums);
		
		//adds evens
		for(int i = 0; i < 10; i++)
		{
			if(nums.get(i) % 2 == 0)
			{
				sum += nums.get(i);
			}
		}
		System.out.println(sum);
		//reset sum
		sum = 0;
		
		//adds odds
		for(int i = 0; i < 10; i++)
		{
			if(nums.get(i) % 2 == 1)
			{
				sum += nums.get(i);
			}
		}
		System.out.println(sum);
		
		//removing primes
		for(int i = 1; i < nums.size(); i++)
		{
			boolean isPrime = true;
			for(int y = 2; y < nums.get(i); y++) 
			{
				if(nums.get(i) % y == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				nums.remove(i);
				i--;
			}
		}
		System.out.println(nums);
				
	}

}
