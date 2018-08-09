package multivariatePolynomial;

import java.util.ArrayList;
import java.util.List;

public class Term {
	int coefficient;
	List<Variable> listOfVariables;
	
    public Term(int coefficient){
    	this.coefficient = coefficient;
    	listOfVariables = new ArrayList<Variable>();
    }
    
    public boolean addVariable(Variable variable){
    	return listOfVariables.add(variable);
    }
	
    public boolean deleteVariable(Variable variable){
    	return listOfVariables.remove(variable);
    }
    
    public String getTerm(){
    	String termString = " + (";
    	termString=termString+coefficient+" ";
    	for(Variable variable: listOfVariables){
    		termString = termString+variable.getVariableSymbol() + "^" + variable.getPower() +" ";
    	}
    	return  termString + ")";
    }
 }
