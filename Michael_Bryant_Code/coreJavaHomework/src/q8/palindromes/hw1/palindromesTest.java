package q8.palindromes.hw1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class palindromesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(palindromes.checkPalindrome("boob"), true);
		assertEquals(palindromes.checkPalindrome("booob"), true);
		assertEquals(palindromes.checkPalindrome("booooooob"), true);
		assertEquals(palindromes.checkPalindrome("test"), false);
		assertEquals(palindromes.checkPalindrome("racecar"), true);
		assertEquals(palindromes.checkPalindrome("napkin"),false);
	}

}
