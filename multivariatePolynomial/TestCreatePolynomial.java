package multivariatePolynomial;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCreatePolynomial {
	MultiVariatePolynomial multiVariatePolynomial = new MultiVariatePolynomial();

	public TestCreatePolynomial() {
		Variable variable1 = new Variable('a', 3);
		Variable variable2 = new Variable('b', 5);
		Variable variable3 = new Variable('c', 7);
		Variable variable4 = new Variable('d', 3);
		Variable variable5 = new Variable('e', 5);
		Variable variable6 = new Variable('f', 5);

		Term term1 = new Term(4);
		term1.addVariable(variable1);
		term1.addVariable(variable4);
		term1.addVariable(variable3);

		Term term2 = new Term(5);
		term2.addVariable(variable2);
		term2.addVariable(variable4);

		Term term3 = new Term(6);
		term3.addVariable(variable5);
		term3.addVariable(variable6);

		multiVariatePolynomial.addTerm(term1);
		multiVariatePolynomial.addTerm(term2);
		multiVariatePolynomial.addTerm(term3);
	}

	@Test
	public void test() {
		String actualResult = multiVariatePolynomial.getPolyNomial();
		String ExpectedResult = " + (4 a^3 d^3 c^7 ) + (5 b^5 d^3 ) + (6 e^5 f^5 )";
		assertEquals("checking the polynomial representation", ExpectedResult,
				actualResult);
	}
}
