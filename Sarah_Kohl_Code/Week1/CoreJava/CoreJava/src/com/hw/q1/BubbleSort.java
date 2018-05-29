package com.hw.q1;

public class BubbleSort{
	
	private static void swap(Integer[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	public static void sort(Integer[] array) {
		
		
		for(int inv = 0; inv<array.length;inv++)
		{
			for(int runner = inv; runner<array.length;runner++)
			{
				if(array[runner] < array[inv])
				{
					swap(array, inv, runner);
				}
				
			}
		}
		
	}

}
