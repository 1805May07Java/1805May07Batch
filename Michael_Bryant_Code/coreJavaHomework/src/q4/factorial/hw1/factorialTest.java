package q4.factorial.hw1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class factorialTest {

	factorial f;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before method");
		 f = new factorial();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
	}

	@Test
	public void test() {
		assertEquals(factorial.fact(-4), -24);
		assertEquals(factorial.fact(0), 1);
		assertEquals(factorial.fact(1), 1);
		assertEquals(factorial.fact(2), 2);
		assertEquals(factorial.fact(3), 6);
		assertEquals(factorial.fact(4), 24);
		
		assertNotEquals(factorial.fact(-4),24);
		assertNotEquals(factorial.fact(0),0);
	}
	 
	

}
