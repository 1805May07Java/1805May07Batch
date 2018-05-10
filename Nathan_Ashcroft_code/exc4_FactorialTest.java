package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc4_FactorialTest {
	exc4_Factorial f;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		f = new exc4_Factorial();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int fact = 3;
		System.out.println(f.fact(fact));
	}

}
