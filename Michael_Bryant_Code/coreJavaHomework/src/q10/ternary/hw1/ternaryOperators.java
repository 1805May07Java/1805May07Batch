package q10.ternary.hw1;

public class ternaryOperators {

	public static void main(String[] args) {
		try {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		
		System.out.println(compare(n1,n2));
		} catch(Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Enter an arguement!");
			
		}
	}
	
	public static String compare(int n1, int n2) {
		String compare = (n1 > n2) ? "n1 is greater" : (n1< n2) ? "n2 is greater" : "n1 and n2 are equal!";
		return compare;
	}

}
