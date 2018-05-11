package com.revhomework.Question1;

public class Question1Bubblesort 

{
	
	public static void main(String args[]) 
	{
		//our array to be sorted
		int[] sortable = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		sort(sortable);
		
		
	}
	
	
	
	public static void sort(int[] list) 
	{
		
		
		//our holding and counting variables
		int sortChange = 0;
		int grandCount =0;
		int holder =0;
		
		//declaring i
		int i;
		
		
		//show what we start with
		System.out.println("Here is the unsorted list.");
		for(i=0; i < list.length; i++) 
		{
			System.out.print(list[i] + " ");
		}
		
		//line break
		System.out.println();
		
		do 
		{
			//reset the sort condition
			sortChange = 0;
			
			//the for loop will check each of the elements or for out of order
			for(i=0; i < list.length; i++) 
			{
				
				//checks if we are at the end of the array and cannot go any farther
				if(i +1 != list.length)
				{	
					
					//performs the check and switch if needed
					if(list[i] > list[i + 1]) 
					{
						sortChange++;
						holder = list[i+1];
						list[i+1] = list[i];
						list[i] = holder;
					
					}
					
				}
				
			}
			//increment how many times we searched the list
			grandCount++;
			
		}while(sortChange != 0);
		
		//line break
		System.out.println();
		System.out.println("Here is the sorted list.");
		//show the new list
		for(i=0; i < list.length; i++) 
		{
			System.out.print(list[i] + " ");
		}
		
		//line break
		System.out.println();
		
		System.out.println("The number of times the sort looked at the list is: " + grandCount);
	} 
	

}
