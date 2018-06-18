package q2.Fibonacci.hw1;

public class Fibonacci {

	public static void main(String[] args) {
		
		
		System.out.print("First 25 Fibonacci numbers: \n");
		
		
		int[] fibNumber= new int[25];
		
		fibNumber = fib(fibNumber);
		
		printArray(fibNumber);

	}
	
	public static int[] fib(int[] fib) {
		fib[0]= 0;
		fib[1]=1;
		for(int i= 2; i < fib.length; i++) {
			fib[i] = fib[i-2] + fib[i -1];
		}
		return fib;
	}
	
	public static void printArray(int[] printArray) { 
		System.out.print("[");
		
		for(int i = 0; i < printArray.length; i++) {
		System.out.print(" " + printArray[i]);
		}
		
		System.out.println(" ]");
	}

}
