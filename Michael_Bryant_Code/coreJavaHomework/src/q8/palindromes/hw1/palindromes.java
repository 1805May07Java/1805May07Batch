package q8.palindromes.hw1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class palindromes {

	public static void main(String[] args) {
	
		ArrayList<String> palindromes = new ArrayList<String>();
		ArrayList<String> nonePal = new ArrayList<String>();
		
		for(String s: args) {
			if(checkPalindrome(s)) {
				palindromes.add(s);
			}else {
				nonePal.add(s);
			}
		}
		System.out.println("Palindromes in list: ");
		System.out.println(palindromes);
		System.out.println();
		System.out.println("None Palindromes in list: ");
		System.out.println(nonePal);

	}

	public static boolean checkPalindrome(String s1) {
		boolean isPal = true;
		
		for(int i = 0; i < s1.length()/2; i++) {
			if(s1.charAt(i) != s1.charAt((s1.length()-i)-1)) {
				isPal = false;
				break;
			}
			
		}
		
		
		return isPal;
	}

}
