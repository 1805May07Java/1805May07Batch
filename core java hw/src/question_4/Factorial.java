package question_4;

public class Factorial {
	public static int nFactorial(int n) {
		if(n == 0) return 0;
		/*
		 * If the result goes past a 32-bit integer, this will break
		 * int answer will store the answer
		 * The algorithm loops up to n, and multiplies the current answer to current iteration
		 * So 'answer' gets gradually bigger for each iteration of the foor-loop
		 */
		int answer = 1;
		for(int i=2; i<=n; i++) {
			answer *= i;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(nFactorial(5));
	}
}
