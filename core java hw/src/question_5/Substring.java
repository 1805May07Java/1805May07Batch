package question_5;

public class Substring {
	public static String substringMethod(String str, int idx) {
		/*
		 * The plan is to make a char array and fill it with each char in str from 0 to idx-1
		 * idx tells us the size we need for the array, so we can just iterate
		 * through 'str' with a for-loop from 0 to idx
		 * After the array is filled, we convert it to a string with the String constructor.
		 */
		char[] answer = new char[idx];
		for(int i=0; i<idx; i++) {
			answer[i] = str.charAt(i);
		}
		return new String(answer);
	}
	public static void main(String[] args) {
		String str = substringMethod("Hello World", 5);
		System.out.println(str);
	}
}
