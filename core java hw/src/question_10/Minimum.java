package question_10;

public class Minimum {
	
	/*
	 * Finds the minimum of 2 numbers with a ternary operator
	 */
	public static double min(double x, double y) {
		return x < y ? x : y;
	}
	
	public static void main(String[] args) {
		System.out.println(min(5, 4));
		System.out.println(min(3, 7));
		System.out.println(min(1, 1));
	}
}
