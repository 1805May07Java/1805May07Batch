package q10.ternary.hw1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ternaryOperatorsTest {

	@Test
	public void test() {
		assertEquals(ternaryOperators.compare(10, 4), "n1 is greater");
		assertEquals(ternaryOperators.compare(4, 10),"n2 is greater");
		assertEquals(ternaryOperators.compare(10, 10), "n1 and n2 are equal!");
	}

}
