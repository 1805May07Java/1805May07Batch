package question03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringReverseTest {

	@Test
	void test() {
		StringReverse sr;
		String test = "testing";
		String correctOutput = "gnitset";
		sr.reverse(test);
		assertEquals(test,correctOutput);
		fail("Not yet implemented");
	}

}
