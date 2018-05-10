package Q8;

public class Palindromes {
	public boolean palindromes(String w1,int i) {
		// Determine if word is a palidrome
			if(i < w1.length()) {
				if(w1.charAt(i) == w1.charAt(w1.length()-1-i) ){
					return true;
				}
			}else {
				assert false;
			}
		return false;
	}
}
