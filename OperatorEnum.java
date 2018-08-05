package DSASession2Part1.InfixToPostfix.operators;

public enum OperatorEnum {
		OPEN_PARANTHESIS("(",15),
		CLOSE_PARANTHESIS(")",14),
		DIVIDE("/",13),
		MULTIPLY("*",12),
		ADD("+",11),
		SUBTRACT("-",10),
		EQUALS("==",9),
		NOT_EQUALS("!=",8),
		LESS_THAN("<",7),
		GREATER_THAN(">",6),
		LESS_THAN_OR_EQUAL("<=",5),
		GREATER_THAN_OR_EQUAL(">=",4),
		AND("&&",3),
		OR("||",2),
		NOT("!",1);
		
		private String operatorRepresentation;
		private int operatorValues;
		
		OperatorEnum(String operatorRepresentation, int operatorValues)
		{
			this.operatorRepresentation = operatorRepresentation;
			this.operatorValues =operatorValues;
		}

		public String getOperatorRepresentation() {
			return this.operatorRepresentation;
		
		}

		public int getOperatorValues() {
			return this.operatorValues;
		}

}
