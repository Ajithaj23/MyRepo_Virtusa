import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class JunitAddTest {

	@Test
	public void test() {
junitadd s=new junitadd();
		
		assertEquals(2,s.divide(5, 2));
		
	}

}
