package question05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubStringTest {
	SubString ss;
	@Test
	void test() {
		String full = "testing";
		int index1 = 0, index2 = 3;
		String corrSubString = "test";
		ss.subString(full, index1, index2);
		fail("Not yet implemented");
	}

}
