package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc14_caseTest {
	exc14_case n;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		n = new exc14_case();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		n.cas(1, 5433);
		n.cas(2, 533244);
		n.cas(3, 5);
	}

}
