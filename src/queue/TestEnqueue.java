package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnqueue {

	@Test
	public void testEnqueue() {
		QueueLinklist<Object> s = new QueueLinklist<Object>();
		s.enqueue(2);
		s.enqueue('a');
		s.enqueue("HELLO");
		s.enqueue(2.20);
		s.enqueue("!!");
		Object[] expectedResult = new Object[] { 2, 'a', "HELLO", 2.2, "!!" };
		assertArrayEquals("elements are added in the queue",expectedResult, s.getQueue());
	}
	
	@Test
	public void test2Enqueue() {
		QueueLinklist<Object> objectOfQueue = new QueueLinklist<Object>();
		assertArrayEquals("retruns null if queue is empty",null, objectOfQueue.getQueue());
	}

}
