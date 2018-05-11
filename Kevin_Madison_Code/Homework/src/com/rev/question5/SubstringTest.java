package com.rev.question5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubstringTest {
	Substring s;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		s = new Substring();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	@Test
	void test() {
		String str = "substring this";
		String expected = "substring";
		
		assertEquals(s.substringThis(str, 9), expected);
	}

}
