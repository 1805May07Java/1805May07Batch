package q6.even.hw1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import q5.substring.hw1.substring;

public class evenNumberTest {
	
	evenNumber e;

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
		e = new evenNumber();
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After Method");
	}

	@Test
	public void test() {
		assertEquals(evenNumber.isEven2(4), true);
		assertEquals(evenNumber.isEven2(3), false);
		assertEquals(evenNumber.isEven2(12), true);
		assertEquals(evenNumber.isEven2(13), false);
		assertEquals(evenNumber.isEven2(-4), true);
	}

}
