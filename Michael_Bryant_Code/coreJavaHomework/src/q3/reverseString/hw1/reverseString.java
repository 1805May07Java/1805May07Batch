package q3.reverseString.hw1;

public class reverseString {

	public static void main(String[] args) {
		
		if(!args[0].isEmpty()) {
		String reverseMe = args[0];
		
		System.out.println("Original string: " + reverseMe);
		System.out.print("Your string reversed: ");
		
		//Print out the Reverse of the argument string
		reverse(reverseMe, reverseMe.length()-1);
		System.out.println();
		}
		

	}
	
	//!!!Recursive loop to print characters in reverse!!!
	public static void reverse(String reverseMe, int length) {
		
		System.out.print(reverseMe.charAt(length));
		if(length != 0) {
			reverse(reverseMe, --length);
		}
		
	
	}
}
