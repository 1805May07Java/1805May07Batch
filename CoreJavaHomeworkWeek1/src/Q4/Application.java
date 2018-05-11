package Q4;

public class Application {
	static int n = 5;
	public static void main(String[] args) {
		
       //Q4. Write a program to compute N factorial.
		Application app = new Application();
		int ans = app.calcFactorial(n);
		System.out.println(ans);
	}

	private int calcFactorial(int n) {
		// TODO Auto-generated method stub
		int fact=1;
		for(int i=1; i<=n; i++) {
			  fact *= i;
		
		}
		
		
		return fact;
	}

}
