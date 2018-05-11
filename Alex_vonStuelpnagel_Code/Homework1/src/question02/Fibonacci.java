package question02;

public class Fibonacci {
	
	public static void main(String [] args) {
		printFibonacci();
	}
	
	public static void printFibonacci() {
		int nMinusOne = 0;
		int nMinusTwo = 0;
		for ( int i=0; i<25; i++) {
			if (i==0) {
				System.out.print(0 + ", ");
				nMinusOne = 1;
			} else if(i==1 || i==2){
				System.out.print(1 + ", ");
        		nMinusTwo = 1;
			} else {
				int temp;
				temp = nMinusOne + nMinusTwo;
				nMinusTwo = nMinusOne;
				nMinusOne = temp;
				System.out.print(nMinusOne + ", ");
			}
		}
	}
}
