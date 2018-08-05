package DSASession2Part1.PostfixEvaluation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostFixEvaluationTest {

	@Test
	public void testPostfixEvaluation() {
		PostfixEvaluation obj = new PostfixEvaluation("4 2 / 3 8 * +");
		obj.postfixEvaluation();
		assertEquals(26, obj.getSum());
	}

	@Test
	public void testPostfixEvaluation1() {
		PostfixEvaluation obj = new PostfixEvaluation("4 2 / 3 8 * + -");
		obj.postfixEvaluation();
		assertEquals("End Of Integers while parsing the operators",0, obj.getSum());
	}
	
	@Test
	public void testPostfixEvaluation2() {
		PostfixEvaluation obj = new PostfixEvaluation("4 2 / 3 8 * + 3 4 * + 5 -");
		obj.postfixEvaluation();
		assertEquals(33, obj.getSum());
	}
	
	@Test
	public void testPostfixEvaluation3() {
		PostfixEvaluation obj = new PostfixEvaluation("4 2 / 3 8 * + 3 -4 * + 5 -");
		obj.postfixEvaluation();
		assertEquals(9, obj.getSum());
	}
	
	@Test
	public void testPostfixEvaluation4() {
		PostfixEvaluation obj = new PostfixEvaluation("4 0 / 3 8 * + 3 -4 * + 5 -");
		obj.postfixEvaluation();
		assertEquals(0, obj.getSum());
	}
}
