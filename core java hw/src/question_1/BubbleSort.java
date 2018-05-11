package question_1;

public class BubbleSort {
	
	public static void bubblesort(int[] arr) {
		// Straight forward bubblesort algorithm.
		// Uses nested for-loops that swap neighboring elements when
		// the left element is bigger than the right element.
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		bubblesort(arr);
		for(int i=0; i<arr.length-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length-1]);
	}
}
