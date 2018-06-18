package q5.substring.hw1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class substringTest {

	substring s;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before Method");
		s= new substring();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After Method");
	}

	@Test
	public void test() {
		assertEquals(substring.sub("fist",0), "f");
		assertEquals(substring.sub("four",1), "fo");
		assertEquals(substring.sub("simple",2), "sim");
		assertEquals(substring.sub("taco",3), "taco");
		assertEquals(substring.sub("add", 6), "add");
		assertEquals(substring.sub("FoUr", 1), "fo");
		
	}

}
