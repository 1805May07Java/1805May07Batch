package com.revhomework.Question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickReversalTest {

	
	QuickReversal test;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		test = new QuickReversal();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testReverse() 
	{
		//not sure how to make an assert here I am not returning anything
		test.reverse("Abra, Kadabra, Alakazam");
		test.reverse("who is the greatest wizard");
		test.reverse("in all the land?");
		test.reverse("Why it is I of course,");
		test.reverse("Veeder Meeker, Sorceror at Law.");
	}

}
