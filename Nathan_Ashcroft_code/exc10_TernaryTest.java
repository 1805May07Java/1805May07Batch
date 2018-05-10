package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc10_TernaryTest {
	exc10_Ternary t;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new exc10_Ternary();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int a = 10;
		int b = 5;
		System.out.println(t.tern(a, b));
	}

}
