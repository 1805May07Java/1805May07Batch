package Q16;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringInputTest {
     Application app=new Application();
     
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//Count 2
		assertSame(2,app.StringCount('d','c'));
		//Count 1
		assertSame(1,app.StringCount('_'));
		assertSame(1,app.StringCount('*'));
	}

	private void assertInteger(int stringCount) {
		// TODO Auto-generated method stub
		
	}

}
