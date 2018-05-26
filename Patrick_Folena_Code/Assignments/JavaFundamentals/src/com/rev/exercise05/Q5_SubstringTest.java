package com.rev.exercise05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q5_SubstringTest {

	static Q5_Substring main;
	static final String test = "Test Sentence";
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q5_Substring();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}

	@Test
	void FullStringTest() {
		assertEquals("Test Sentence", main.subString(test, 0, 12));
	}
	
	@Test
	void EmptyInitialStringTest() {
		assertEquals("", main.subString("", 0, 0));
	}
	
	@Test
	void leftTooFar() {
		assertEquals("Error: Index Out Of Bounds", main.subString(test, -1, 12));
	}
	
	@Test
	void rightTooFar() {
		assertEquals("Error: Index Out Of Bounds", main.subString(test, 0, 13));
	}
	
	@Test
	void leftGTRight() {
		assertEquals("Sent", main.subString(test, 8, 5));
	}
	
	void basicTest() {
		assertEquals("Sent", main.subString(test, 5, 8));
	}

}
