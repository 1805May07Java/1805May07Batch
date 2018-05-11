package Q1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q1 {
	Application app = new Application();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int a[]= {1,2,3,4};
		
		int[] actualResult = app.bubble(a);
		int[] expectedResult= a;
				
		assertSame(expectedResult,actualResult);
				
		
	}
	@Test
	public void test2() {
		int a[]= {4,3,2,1};
		int b[]= {1,2,3,4};
	 
		int[] actualResult = app.bubble(a);
		int[] expectedResult= b;
				
		assertTrue(Arrays.equals(expectedResult, actualResult));
				
		
	}
		 
	}


