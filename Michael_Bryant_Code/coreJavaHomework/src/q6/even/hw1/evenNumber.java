package q6.even.hw1;

public class evenNumber {

	public static void main(String[] args) {
		try {
			int num = Integer.parseInt(args[0]);
			
			if(isEven(num)) {
				System.out.println(num +" is even!");
			}else {
				System.out.println(num +" is odd!");
			}
			
			
		}catch (Exception indexArrayOutOfBounds) {
			System.out.println("Enter an Integer!");
		}
		

	}
	
	
	//Using Integer division to determine if num is even or odd
	public static boolean isEven(int num) {
		boolean isEven = false;
		
		if((num/2)*2 == num) isEven= true;
		
		return isEven;
	}
	
	//Using bitwise we find if num is even or odd
	public static boolean isEven2(int num) {
		boolean isEven;
		if((num & 1) == 0) {
			isEven = true;
		}else {
			isEven = false;
		}
		return isEven;
	}
	
	

}
