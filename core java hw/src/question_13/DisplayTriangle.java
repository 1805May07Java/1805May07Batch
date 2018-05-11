package question_13;

public class DisplayTriangle {
	/*
	 * This function will print a triangle for any height where n>0
	 * Since the triangle alternates between 0 and 1, there's a boolean to check whether we will print a 0 or 1
	 */
	public static void printTriangle(int n) {
		boolean zero = true;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				// if zero-true, print a 0 otherwise print 1, then make zero it's opposite
				if(zero)
					System.out.print("0 ");
				else
					System.out.print("1 ");
				zero = !zero;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		printTriangle(4);
	}
}
