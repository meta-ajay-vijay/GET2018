package multivariatePolynomial;

import java.util.ArrayList;
import java.util.List;

public class MultiVariatePolynomial {
	List<Term> listOfTerms;

	MultiVariatePolynomial() {
		listOfTerms = new ArrayList<Term>();
	}

	public boolean addTerm(Term term) {
		return listOfTerms.add(term);
	}

	public boolean removeTerm(Term term) {
		return listOfTerms.add(term);
	}

	public List<Term> getPolynomial() {
		return this.listOfTerms;
	}

	/**
	 * creating the polynomial string by adding all the terms in the list
	 * 
	 * @return
	 */
	public String getPolyNomial() {
		String polynomial = "";
		for (Term term : listOfTerms) {
			polynomial = polynomial + term.getTerm();
		}

		return polynomial;
	}

}
