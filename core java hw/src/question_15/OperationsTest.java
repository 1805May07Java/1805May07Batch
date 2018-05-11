package question_15;

public class OperationsTest {
	

	public static void main(String[] args) {
		UsesOperations u = new UsesOperations();
		System.out.println(u.addition(1, 2)); //expect 3
		System.out.println(u.subtraction(5, 9)); //expect -4
		System.out.println(u.multiplication(3, 3)); //expect 9
		System.out.println(u.division(10, 2)); //expect 5
		
	}

}
