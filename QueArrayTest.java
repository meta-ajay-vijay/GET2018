package queArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueArrayTest {

	@Test
	public void testAdd() {
		QueArray obj = new QueArray(3);
		assertEquals(true,(obj.add(1)));
	}
	
	@Test
	public void testAdd1() {
		QueArray obj = new QueArray(3);
		obj.add(1);
		assertEquals(true,(obj.add(5)));
	}

	@Test
	public void testAdd2() {
		QueArray obj = new QueArray(3);
		obj.add(1);
		obj.add(5);
		assertEquals(true,(obj.add(1000)));
	}

	@Test
	public void testDelete() {
		QueArray obj = new QueArray(3);
		obj.add(1);
		obj.add(5);
		obj.add(1000);
		assertEquals(true,(obj.delete()));
	}

	@Test
	public void testIsEmpty() {
		QueArray obj = new QueArray(3);
		obj.add(1);
		obj.add(5);
		obj.add(1000);
		obj.delete();
		assertEquals(false,(obj.isEmpty()));
	}
}
