package question_12;

public class PrintEven {
	public static void main(String[] args) {
		/*
		 * First we make a loop to store every int from 1-100 in an array
		 */
		int[] arr = new int[100];
		for(int i=1; i<=100; i++) {
			arr[i-1] = i;
		}
		/*
		 * Uses the enhanced for-loop to traverse the array
		 * We use a mod operator to even if a number is even 
		 */
		for(int num : arr) {
			if(num%2 == 0) System.out.println(num);
		}
	}
}
