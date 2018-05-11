package question08;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

class ArrayListPalindromeTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	ArrayListPalindrome apt;
	
	void test() {
		ArrayList<String> input = apt.arrListInit();
		String correctOutput = "madam, civic, radar, sexes, kayak, refer, did, ";
		assertEquals(correctOutput, outContent.toString());
		fail("Not yet implemented");
	}

}
