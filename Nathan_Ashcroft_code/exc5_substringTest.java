package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc5_substringTest {
	exc5_substring s;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		s = new exc5_substring();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String str = "Hello my Love";
		int idx = 8;
		String str2 = s.sub(str, idx);
		System.out.println(str2);
	}

}
