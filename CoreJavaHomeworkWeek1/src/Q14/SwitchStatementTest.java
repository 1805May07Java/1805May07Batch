package Q14;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SwitchStatementTest {
	Application swMenu = new Application();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test1() {
		
		swMenu.Menu(1);
	}
	@Test
	public void test2() {
		
		swMenu.Menu(2);
	}
	@Test
	public void test3() {
		
		swMenu.Menu(3);
	}

}
