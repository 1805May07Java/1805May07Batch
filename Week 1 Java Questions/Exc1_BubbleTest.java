package com.rev.questions;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Exc1_BubbleTest {
	Exc1_Bubble b;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		b = new Exc1_Bubble();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		int[] array2 = new int[11];
		array2 = b.bubble(array);
		System.out.println("");
		for(int j = 0; j < array.length; j++) {System.out.print(array2[j]);}
	}

}
