package DSASession2Part1.InfixToPostfix;
import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {
	
	@Test
	public void testPostfixRepresentation() {
		InfixToPostfix obj = new InfixToPostfix("a + b + c + d * n / p");
		String expectedResult =  "ab+c+dnp/*+";
		obj.postfixRepresentation();
		assertEquals(expectedResult,obj.getPostfix());
	}
	
	@Test
	public void testPostfixRepresentation1() {
		InfixToPostfix obj = new InfixToPostfix("a * b + c + d * n / p");
		String expectedResult =  "ab*c+dnp/*+";
		obj.postfixRepresentation();
		assertEquals(expectedResult,obj.getPostfix());
	}

	@Test
	public void testPostfixRepresentation2() {
		InfixToPostfix obj = new InfixToPostfix("a && b + c <= d * n / p");
		String expectedResult =  "abc+dnp/*<=&&";
		obj.postfixRepresentation();
		assertEquals(expectedResult,obj.getPostfix());
	}
	
	@Test
	public void testPostfixRepresentation3() {
		InfixToPostfix obj = new InfixToPostfix("a && b ! c <= d * n / p");
		String expectedResult =  "ab&&cdnp/*<=!";
		obj.postfixRepresentation();
		assertEquals(expectedResult,obj.getPostfix());
	}
	
	@Test
	public void testPostfixRepresentation4() {
		InfixToPostfix obj = new InfixToPostfix("a && b ( c <= d ) n / p");
		String expectedResult =  "abcd<=np/&&";
		obj.postfixRepresentation();
		assertEquals(expectedResult,obj.getPostfix());
	}
}
