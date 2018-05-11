package question_8;

import java.util.ArrayList;

public class StorePalindromes {
	/*
	 * Before we can store a list of palindromes, we need to know if a given string is even a palindrome
	 * So given a String named str, we check for the first char and the last char, then the second and second to last, etc.
	 * If at any point we find that char1 != char2, then we know it's not a palindrome and can do an early return false;
	 * If the for-loop reaches the end then the String must be a palindrome
	 */
	private static boolean isPalindrome(String str) {
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Since we have a helper method to find whether one given String is a palindrome,
	 * All we need to do is parse through the array of Strings and use the helper method for each element.
	 * We store each palindrome into the ArrayList and then return the ArrayList
	 */
	public static ArrayList<String> palindromes(String[] arr) {
		ArrayList<String> answer = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(isPalindrome(arr[i])) {
				answer.add(arr[i]);
			}
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> list = palindromes(arr);
		System.out.println(list.toString());
	}
}
