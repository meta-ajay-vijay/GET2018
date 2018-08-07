package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPeek {

	@Test
	public void testPeek() {
		QueueLinklist<Object> s = new QueueLinklist<Object>();
		s.enqueue(2);
		s.enqueue('a');
		s.enqueue("HELLO");
		s.enqueue(2.20);
		s.enqueue("!!");
		assertEquals("peek element is first elemet of queue",2, s.peek());
	}
	
	@Test
	public void test2Peek() {
		QueueLinklist<Object> s = new QueueLinklist<Object>();
		assertEquals("returns null if queue is empty",null, s.peek());
	}


}
