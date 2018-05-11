package com.revhomework.Question18;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringWarperTest {
	
	//set up reference to object
	StringWarper warp;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		//make fresh object
		warp = new StringWarper();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		//null object reference
		warp = null;
	}

	
	
	//tests past here
	@Test
	void testCheckUpper() 
	{
		assertEquals(warp.checkUpper("Hallmark"), true);
		assertEquals(warp.checkUpper("channel"), false);
	}

	@Test
	void testMakeLower() 
	{
		assertNotEquals(warp.makeLower("HAIL THE KING"),"HAIL THE KING");
	}

	@Test
	void testMakeNumber() 
	{
		assertEquals(warp.makeNumber("Wonder what will happen?"), 2304);
	}

}
