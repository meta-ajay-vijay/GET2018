package studentCounselling;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAllotStudnet {

	@Test
	public void test() {
		AllotSeat allot = new AllotSeat();
		boolean result = allot.allotSeat();
		assertEquals(true, result);
	}

}
