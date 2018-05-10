package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc6_modTest {
	exc6_mod m;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		m = new exc6_mod();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int tst = 456999;
		System.out.println(m.mod(tst));
	}

}
