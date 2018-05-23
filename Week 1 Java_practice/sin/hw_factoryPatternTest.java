package com.rev.sin;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class hw_factoryPatternTest {

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
		hw_factoryPattern shapeF = new hw_factoryPattern();

	      //get an object of Circle and call its draw method.
	      shape shape1 = shapeF.getShape("circle");

	      //call draw method of Circle
	      shape1.draw();

	      //get an object of Rectangle and call its draw method.
	      shape shape2 = shapeF.getShape("rectangle");

	      //call draw method of Rectangle
	      shape2.draw();

	      //get an object of Square and call its draw method.
	      shape shape3 = shapeF.getShape("triangle");

	      //call draw method of circle
	      shape3.draw();
	}

}
