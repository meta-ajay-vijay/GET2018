package multivariatePolynomial;

public class Variable {
	private char variableSymbol;
	private int power;

	public Variable(char variableSymbol, int power) {
		this.variableSymbol = variableSymbol;
		this.power = power;
	}

	/**
	 * @return the variableSymbol
	 */
	public char getVariableSymbol() {
		return variableSymbol;
	}
	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

}
