package com.rev.bubblesort;

public class Bubblesort {

	static void bubbleSort(int arr[], int n)
	    {
	        int i, j, temp;
	        boolean swapped;
	        for (i = 0; i < n - 1; i++) 
	        {
	            swapped = false;
	            for (j = 0; j < n - i - 1; j++) 
	            {
	            	//Test if number is bigger than next
	                if (arr[j] > arr[j + 1]) 
	                {
	                    //If true, swap numbers
	                    temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                    swapped = true;
	                }
	            }
	 
	            // Break if no numbers swapped
	            if (swapped == false)
	                break;
	        }
	    }
	 
	    // Function for printing array 
	    static void printArray(int arr[], int size)
	    {
	        int i;
	        for (i = 0; i < size; i++)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	 
	    // Print hard coded array
	    public static void main(String args[])
	    {
	        int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	        int n = arr.length;
	        bubbleSort(arr, n);
	        printArray(arr, n);
	    }
	}