package q5.substring.hw1;

public class substring {
	//This is a look at the Strings substring method.
	//Requires a String and int and will print the letters
	//of string up to the given int
	

	public static void main(String[] args) {
		try {
			String str = args[0];
			int idx = Integer.parseInt(args[1]);
			if(idx >= 0) {
			System.out.println(sub(str, idx));
			}else {
				System.out.println("not a valid index");
			}
		}catch (Exception ArrayIndexOutOfBoundsError) {
			System.out.println("Enter a String and an Integer!");
		}
		
		

	}
	
	public static String sub(String str, int idx) {
		String ss ="";
		str.toLowerCase();
		
		if(idx > str.length()) idx = str.length()-1; //Substring maxIndex == str.length()
		
		for(int i = 0;i <= idx; i++) {
			ss = ss + str.charAt(i);
		}
		
		return ss;
	}

}
