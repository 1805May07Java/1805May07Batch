package question_7;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee("John", "HR", 40);
		Employee e2 = new Employee("Not John", "Management", 55);
		
		if(e1.compare(e1, e2) < 0) {
			System.out.println(e1.toString() +"\n");
			System.out.println(e2.toString());
		}
		else if(e1.compare(e1, e2) > 0) {
			System.out.println(e2.toString() +"\n");
			System.out.println(e1.toString());
		}
		else {
			System.out.println("They're the same");
			System.out.println(e2.toString() +"\n");
			System.out.println(e1.toString());
		}
	}
}
