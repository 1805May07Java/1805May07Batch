package question01;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String [] args) {
		int [] toSort = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int length = toSort.length;
		
		for ( int i=1; i<length; i++) {
			for ( int j=0; j<length-1; j++) {
				int temp;
				if (toSort[j]>toSort[i]) {
					temp = toSort[i];
					toSort[i] = toSort[j];
					toSort[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(toSort));
	}
}
