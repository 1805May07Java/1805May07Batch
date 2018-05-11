package question_6;

public class IsEven {
	/*
	 * We're gonna take advantage of the differences between floating and integer division.
	 * Basically, integer division truncates any floating points, so as an example:
	 * num = 15
	 * if num is a double, we get 15/2 = 7.5
	 * if num is an int, we get 15/2 = 7 (the 0.5 is lost); 
	 * We can then convert the int to a double and then compare whether 7.5 == 7.0
	 */
	public static boolean isEven(int num) {
		double temp = num;
		return temp/2 == (double)(num/2);
	}
	
	public static void main(String[] args) {
		System.out.println(isEven(8));
		System.out.println(isEven(15));
	}
}

