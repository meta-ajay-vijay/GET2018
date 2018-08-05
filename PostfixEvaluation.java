package DSASession2Part1.PostfixEvaluation;

import DSASession2Part1.PostfixEvaluation.stack.StackLinklist;
import DSASession2Part1.PostfixEvaluation.arithematicoperator.OperatorEnum;

public class PostfixEvaluation{
	StackLinklist<Integer> intValues = new StackLinklist<Integer>();
	String inputExpression ="";
	int sum = 0;
	
	public PostfixEvaluation(String inputExpression) {
		this.inputExpression = inputExpression + " ";
	}
	
	private boolean checkOperator(String currentChar) {
		for (OperatorEnum template : OperatorEnum.values()) {
			if (currentChar.equals(template.getOperatorRepresentation())) {
				return true;
			}
		}
		return false;
	}
	

	private OperatorEnum getOperatorEnum(String currentChar) {
		for (OperatorEnum template : OperatorEnum.values()) {
			if (currentChar.equals(template.getOperatorRepresentation())) {
				return template;
			}
		}
		return null;
	}
	
	public void postfixEvaluation() {
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
					OperatorEnum template = getOperatorEnum(currentChar);
					int value1 = 0;
					int value2 = 0;
					try{
						value1 = intValues.peek();
						if(!intValues.pop())
						{
							throw new Exception("");
						}
						value2 = intValues.peek();
						if(!intValues.pop())
						{
							throw new Exception("");
						}
					}catch(Exception e)
					{
						System.out.println("End Of Integers while parsing the operators");
						e.getMessage();
						break;
					}
					switch(template)
					{
					case ADD:
						sum = value1+value2;
						intValues.push(sum);
						break;
						
					case DIVIDE:
						sum = value2/value1;
						intValues.push(sum);
						break;
						
					case MuULTIPLY:
						sum = value1*value2;
						intValues.push(sum);
						break;
						
					case SUBTRACT:
						sum = value2-value1;
						intValues.push(sum);
						break;
					}
				}
				else{
					int currentNumericValue;
					try{
						currentNumericValue = Integer.parseInt(currentChar);
						intValues.push(currentNumericValue);
					}
					catch(NumberFormatException e)
					{
						System.out.println("The expression contains tokens unrecognizable as Integer");
						e.getMessage();
					} 
				}
			}
		}
		if(!intValues.isEmpty() && intValues.getHead() == intValues.getTail())
		{
			sum = intValues.peek();
			intValues.pop();
		}
		else
		{
			System.out.println("The Evaluation Failed");
			while(!intValues.isEmpty())
			{
				intValues.pop();
			}
		}
	}

	public int getSum()
	{
		return this.sum;
	}
	
	public static void main(String []args)
	{
		PostfixEvaluation obj = new PostfixEvaluation("32 22 + 12 - 2 * 25 / 45 - 5 /");
		obj.postfixEvaluation();
		System.out.println(obj.getSum());
	}
}