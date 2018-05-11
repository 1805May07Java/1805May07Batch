package question_11;
import question_11_extrapackage.SomeClass;

public class ImportingStuff {
	public static void main(String[] args) {
		SomeClass sc = new SomeClass(5.5, 3.25);
		System.out.println("Two variables: " + sc.getX() + ", " + sc.getY());
	}
}
