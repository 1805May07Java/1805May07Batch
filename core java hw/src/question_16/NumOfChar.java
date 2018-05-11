package question_16;

public class NumOfChar {
	public static void main(String[] args) {
		/*
		 * The question wants us to take in one String argument from the cmd line
		 * Then output the number of characters - this can be done very simply with the string's length() method.
		 */
		String str = args[0];
		System.out.println(str.length());
	}
}
