package q1.bubblesort.hw1;

public class bubbleSort {

	public static void main(String[] args) {
		//Array we want sorted
		int[] sortMe = {1,0,5,6,3,2,3,7,9,8,4};
		
		//Shows user Array before
		System.out.println("Before bubble sort: ");
		printArray(sortMe);
		//Shows user Array after
		System.out.println("After bubble sort: ");
		printArray(Sort(sortMe));
	}
	
	public static int[] Sort(int[] sortMe) {
		
		for(int i = 0; i < sortMe.length; i++) {
			for(int j= i + 1; j < sortMe.length; j ++) {
				if(sortMe[i] > sortMe[j]) {
					sortMe[i] = sortMe[i] + sortMe[j];
					sortMe[j] = sortMe[i] - sortMe[j];
					sortMe[i] = sortMe[i] - sortMe[j];
					
				}
			}
		}
		
		return sortMe;
	}
	
	public static void printArray(int[] sortMe) { 
		System.out.print("[");
		
		for(int i = 0; i < sortMe.length; i++) {
		System.out.print(" " + sortMe[i]);
		}
		
		System.out.println(" ]");
	}

}
