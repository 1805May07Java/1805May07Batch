package question_3;

public class ReverseString {
	public static String reverse(String s) {
		/* The algorithm is as follows:
		 * Convert the string to a char array (easier to swap).
		 * Swap the first element with the last, second element with the second to last, etc.
		 * We only need to go to half the array.
		 * Convert the array back to a string and return the new result
		 */
		char[] arr = s.toCharArray();
		for(int i=0; i<arr.length/2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		return new String(arr);
	}
	
	public static void main(String[] args) {
		String answer = reverse("Hello World");
		System.out.println(answer);
	}
}
