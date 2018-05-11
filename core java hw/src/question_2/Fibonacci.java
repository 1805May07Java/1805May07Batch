package question_2;

public class Fibonacci {
	public static void fibonacci(int n) {
		// the next 2 if-statements check for edge cases (basically n < 3)
		if(n >= 1) System.out.println(0);
		if(n >= 2) System.out.println(1);

		// Dynamic programming solution that uses 2 variables
		// int f2 stores the 'current' iteration of n,
		// int f1 stores the 'previous' iteration of n
		// The idea is to store f1+f2 into f2, and store the previous value of f2 into f1
		// this will speed up the process much faster than the recursive way
		int f1 = 0, f2 = 1;
		for(int i=2; i<n; i++) {
			int temp = f1 + f2;
			f1 = f2;
			f2 = temp;
			System.out.println(f2);
		}
	}
	
	public static void main(String[] args) {
		fibonacci(25);
	}
}
