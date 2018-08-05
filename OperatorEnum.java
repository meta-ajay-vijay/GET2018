package DSASession2Part1.PostfixEvaluation.arithematicoperator;

public enum OperatorEnum {
	DIVIDE("/"),
	MuULTIPLY("*"),
	ADD("+"),
	SUBTRACT("-");

	private String operatorRepresentation;
	
	OperatorEnum(String operatorRepresentation)
	{
		this.operatorRepresentation = operatorRepresentation;
	}

	public String getOperatorRepresentation() {
		return operatorRepresentation;
	}
	

}
