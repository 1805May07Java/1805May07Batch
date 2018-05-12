package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc3_reverseStringTest {
	exc3_reverseString reverseStr;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		reverseStr = new exc3_reverseString();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String str = "hello i am awesome";
		reverseStr.revString(str);
	}

}
