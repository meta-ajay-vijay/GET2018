package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDequeue {

	@Test
	public void testDqueue() {
		QueueLinklist<Object> s = new QueueLinklist<Object>();
		s.enqueue(2);
		s.enqueue('a');
		s.enqueue("HELLO");
		s.enqueue(2.20);
		s.enqueue("!!");

		s.dequeue();
		Object[] expectedResult = new Object[] {'a', "HELLO", 2.2, "!!" };
		assertArrayEquals("Element has been removed",expectedResult, s.getQueue());
	}
	
	@Test
	public void test1Dqueue() {
		QueueLinklist<Object> s = new QueueLinklist<Object>();
		boolean actualResult = s.dequeue();
		assertEquals("queue does not have any elements", false,actualResult);
	}


}
