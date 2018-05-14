package com.rev.exercise01;

import java.util.Arrays;

public class Q1_BubbleSort {
	public static void main(String[] args)
	{			
		int[] sort = {1,0,5,6,3,2,3,7,9,8,4};
		
		Q1_BubbleSort control = new Q1_BubbleSort();
		
		int[] sorted = control.bubbleSort(sort);
		
		for(int i = 0; i < sorted.length; i++)
		{
			System.out.print(sorted[i] + " ");
		}
	}
	
	public int[] bubbleSort(int[] sort)
	{
		
		float f = 0.0123456f;
		System.out.println(String.format("%.2f", f));
	
		
		if(sort == null)
		{
			System.out.println("I am null");
			return null;
		}
		
		if(sort.length < 1)
		{
			return sort;
		}
		
		int a = 0;
		int z = sort.length - 1;
		
		while(a != z)
		{
			while(a != z)
			{
				if(sort[a] > sort[a+1])
				{
					int temp = sort[a+1];
					sort[a+1] = sort[a];
					sort[a] = temp;
				}
				a++;
			}
			a = 0;
			z--;
		}
		
		return sort;
		
		
	}
}
