package Q17;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimplePrincipleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BigDecimal P = new BigDecimal(10000);
		BigDecimal r =  new BigDecimal(3.875*(1/100));
		int t = 5;
		BigDecimal A = P.multiply(new BigDecimal(1).add((r.multiply(new BigDecimal(t)))));
		//double I = A-P;
		System.out.println(r);
	}

}
