package question_18;

public class TestAbstractClass {
	public static void main(String[] args) {
		UsingAbstractClass nice = new UsingAbstractClass();
		System.out.println(nice.hasUpperCaseLetter("there is One upper"));
		System.out.println(nice.hasUpperCaseLetter("there isn't an upper"));
		System.out.println(nice.convertLowerToUpper("A mix Of UppeR aND LoWEr"));
		nice.addTen("245");
		nice.addTen("cat");
	}
}
