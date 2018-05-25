package Homework;
public class Q1 {
    public static void main(String[] args) {
        //declaring and inputting values in array
        int[] array = new int[]{1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        //calling bubblesort method
        bubbleSort(array);
        //print array elements
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    //bubblesort method
    static void bubbleSort(int[] array) {
        int temp;
        //nested for loop to compare indexes n and n-1.
        //int a is n, int b is n-1
        for (int a = 0; a < array.length; a++) {
            for (int b = 1; b < (array.length - a); b++) {
                //if element at index b-1 is greater than element at index b, swap
                if (array[b-1] > array[b]) {
                    temp = array[b-1];
                    array[b-1] = array[b];
                    array[b] = temp;
                }
            }
        }
    }
}