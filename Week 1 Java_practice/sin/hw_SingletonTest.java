package com.rev.sin;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class hw_SingletonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		hw_Singleton x = hw_Singleton.getInstance();
		hw_Singleton y = hw_Singleton.getInstance();
		hw_Singleton z = hw_Singleton.getInstance();
 
        x.str = (x.str).toUpperCase();
 
        System.out.println("String from x is " + x.str);
        System.out.println("String from y is " + y.str);
        System.out.println("String from z is " + z.str);
        System.out.println("\n");
 
        z.str = (z.str).toLowerCase();
 
        System.out.println("String from x is " + x.str);
        System.out.println("String from y is " + y.str);
        System.out.println("String from z is " + z.str);
	}

}
