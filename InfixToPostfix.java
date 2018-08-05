package DSASession2Part1.InfixToPostfix;

import DSASession2Part1.InfixToPostfix.operators.OperatorEnum;
import DSASession2Part1.InfixToPostfix.stack.StackLinklist;

public class InfixToPostfix {
	StackLinklist<OperatorEnum> operatorStack = new StackLinklist<OperatorEnum>();
	String inputExpression = null;
	String outputExpression ="";

	public InfixToPostfix(String inputExpression) {
		this.inputExpression = inputExpression + " ";
	}

	public boolean checkPrecedenceGreater(OperatorEnum firstType,
			OperatorEnum secondType) {
		if (firstType.getOperatorValues() > secondType.getOperatorValues()) {
			return true;
		} else
			return false;
	}

	private boolean checkOperator(String currentChar) {
		for (OperatorEnum template : OperatorEnum.values()) {
			if (currentChar.equals(template.getOperatorRepresentation())) {
				return true;
			}
		}
		return false;
	}

	public void postfixRepresentation() {
		boolean flag =true;
		for (int index = 0, checkWhiteSpaceIndex = index; index < inputExpression.length() - 1; index++) {
			String currentChar ="";

			if (inputExpression.charAt(index + 1) == 32) {
				if (checkWhiteSpaceIndex == index) {
					currentChar = String.valueOf(inputExpression.charAt(index));
				} else {
					for (int i = checkWhiteSpaceIndex; i <= index; i++) {
						currentChar = currentChar + String.valueOf(inputExpression.charAt(i));
					}
				}
				checkWhiteSpaceIndex = index + 2;
				if (checkOperator(currentChar)) {
					OperatorEnum currentOperatorEnum = getOperatorEnum(currentChar);
					try {
						if (currentOperatorEnum != null) {
							if (currentOperatorEnum.getOperatorRepresentation().equals("(")) {
								operatorStack.push(currentOperatorEnum);
							} else if (currentOperatorEnum.getOperatorRepresentation().equals(")")) {
								while (!(operatorStack.peek().getOperatorRepresentation().equals("("))) {
									if (operatorStack.getHead() == operatorStack.getTail()&& !(operatorStack.peek().equals("("))) {
										flag = false;
									}
									outputExpression = outputExpression + operatorStack.peek().getOperatorRepresentation();
									operatorStack.pop();
								}
								operatorStack.pop();
							} else if (!(operatorStack.isEmpty())) {
								if(checkPrecedenceGreater(currentOperatorEnum, operatorStack.peek()))
								{
									operatorStack.push(currentOperatorEnum);
								}
								else if(!(operatorStack.peek().getOperatorRepresentation().equals("(")))
								{
									outputExpression = outputExpression+ operatorStack.peek().getOperatorRepresentation();
									operatorStack.pop();
									operatorStack.push(currentOperatorEnum);
								}
								else
								{
									operatorStack.push(currentOperatorEnum);
								}
							} else {
								operatorStack.push(currentOperatorEnum);
							}
						} else {
							throw new Exception("");
						}
					} catch (Exception e) {
						System.out.println("Some Error in reading the Operator");
					}
				} else {
					outputExpression = outputExpression + currentChar;
				}
			}
		}
		if (!operatorStack.isEmpty()) {
			while (!operatorStack.isEmpty()) {
				outputExpression = outputExpression + operatorStack.peek().getOperatorRepresentation();
				operatorStack.pop();
			}
		}
		if(!flag)
		{
			outputExpression = new String("The Input Expression is Invalid.");
		}
	}

	private OperatorEnum getOperatorEnum(String currentChar) {
		for (OperatorEnum template : OperatorEnum.values()) {
			if (currentChar.equals(template.getOperatorRepresentation())) {
				return template;
			}
		}
		return null;
	}

	public String getPostfix()
	{
		return outputExpression;
	}
	
	public static void main(String args[]) {
		InfixToPostfix obj = new InfixToPostfix("a + b + c + d * n / p");
		obj.postfixRepresentation();
		System.out.println(obj.getPostfix());
		System.out.println(obj.outputExpression.length());
	}
}