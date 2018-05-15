package q4.factorial.hw1;

public class factorial {
	//This program takes in an argument from the command line
	//and then takes the factorial of the number. 
	//Range: -2^32 <= 0 <= 2^32

	public static void main(String[] args) {
		try {
		int factOf = Integer.parseInt(args[0]);
		System.out.println("Factorial of " +factOf +" is " +fact(factOf));
		} catch(Exception ArrayIndexOutOfBoundsException) {
			System.out.println("Enter an integer into the command line!");
			
		}

	}
	
	//3 Cases|| factOf==0 | factOf > 0 | factOf < 0
	public static int fact(int factOf) {
		int factOfResult = 1;
		if (factOf > 0) {
			while(factOf > 0) {
				
				factOfResult *= factOf--;
			}
				
			}else if(factOf < 0) {
				factOf *= -1;
			while(factOf > 0) {
					
				factOfResult *= factOf--;
			}
			factOfResult *= -1;
		}
		return factOfResult;
	}

}
