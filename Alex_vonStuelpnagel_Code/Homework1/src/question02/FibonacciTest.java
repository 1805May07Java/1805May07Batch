package question02;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

public class FibonacciTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Fibonacci f;
	
	public void test() {
		String correctOutput = "0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, "; 
		f.printFibonacci();
		assertEquals(correctOutput, outContent.toString());
		fail("Not yet implemented");
	}

}