package com.rev.exercises;

public class BubbleSort 
{
	void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
 
    /* Prints the array */
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        BubbleSort a = new BubbleSort();
        int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        a.bubbleSort(arr);
        System.out.println("Sorted array");
        a.printArray(arr);
    }
}
