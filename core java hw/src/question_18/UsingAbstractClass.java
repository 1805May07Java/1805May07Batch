package question_18;

public class UsingAbstractClass extends TheAbstractClass {
	
	/*
	 * Need to check if the string has 1+ uppercase letters;
	 * We depend on two methods in the Character wrapper class - isLetter() and toUpperCase();
	 * We first check if the char at a given index is a letter with isLetter(), then
	 * We check if the char is equal to the uppercase version.
	 */
	public boolean hasUpperCaseLetter(String str) {
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			if(Character.isLetter(curr) && curr == Character.toUpperCase(curr)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * We use String's built-in method to convert all characters to Uppercase
	 */
	public String convertLowerToUpper(String str) {
		return str.toUpperCase();
	}
	
	/*
	 * So we need to convert any String to an int, then add ten.
	 * There's no assumed rules for the String, so it could be all numbers or a combination of any char's.
	 * So I felt it was fair to make up some rules as long as the String was converted to an int.
	 * An example is:
	 * if str = "245", we want it to be an int equal to 245, which is 2*10^2 + 4*10^1 + 5*10^0.
	 * Since each char as a numerical representation, I decided that:
	 * if str = "cat", c=51, a=49, t=68
	 * So we get: 51*10^2 + 49*10^1 + 68*10^0 = 5658 
	 * Then we add 10 to the result for 255 and 5668, respectively.
	 */
	public void addTen(String str) {
		int answer = 0;
		for(int i=0; i<str.length(); i++) {
			answer += (str.charAt(i)-'0') * Math.pow(10, str.length()-1-i);
		}
		System.out.println(answer + 10);
	}
}
