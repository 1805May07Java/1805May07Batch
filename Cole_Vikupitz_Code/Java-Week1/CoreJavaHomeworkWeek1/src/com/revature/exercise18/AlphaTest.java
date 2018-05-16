package com.revature.exercise18;

// Imports
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AlphaTest {

	AlphaChild ac;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		ac = new AlphaChild();
	}

	@After
	public void tearDown() throws Exception {
		ac = null;
	}
	
	// Test Case - hasUpperCase()
	@Test
	public void test1() {
		assertEquals(ac.hasUpperCase("This is a test"), true);
		assertEquals(ac.hasUpperCase("this is a test"), false);
		assertEquals(ac.hasUpperCase("THIS IS A TEST"), true);
		assertEquals(ac.hasUpperCase("!@#$%^12334"), false);
		assertEquals(ac.hasUpperCase(""), false);
	}
	
	// Test Case - convertUpperCase()
	@Test
	public void test2() {
		
		assertEquals(ac.convertUpperCase(""), "");
		assertEquals(ac.convertUpperCase("this is a test."), "THIS IS A TEST.");
		assertEquals(ac.convertUpperCase("This Is A Test."), "THIS IS A TEST.");
		assertEquals(ac.convertUpperCase("1234567890!@#$%^&*()"), "1234567890!@#$%^&*()");
		assertEquals(ac.convertUpperCase("THIS IS A TEST."), "THIS IS A TEST.");
	}

}
