package com.rev.exercises;

public class EnchancedFor {

	public static void main(String[] args) 
	{
		int[] nums = new int[100];
		
		for(int i = 0; i < 100; i++)
		{
			nums[i] = i+1;
		}
		
		for(int evens : nums)
		{
			if(evens%2 == 0)
			{
				System.out.println(evens);
			}
		}
		
		
		
	}

}
