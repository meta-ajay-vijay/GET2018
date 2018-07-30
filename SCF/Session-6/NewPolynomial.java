package Assignment7;

import java.util.*;

public final class NewPolynomial {

	private final int[][] coefficientPower;// 0 for coefficient and 1 for power
	Scanner scan = new Scanner(System.in);

	public NewPolynomial(int[][] coefficientPower) {
		int[][] toTrim = new int[2][coefficientPower[0].length];
		for (int i = 0; i < toTrim.length; i++) {
			for (int j = 0; j < toTrim[0].length; j++) {
				toTrim[i][j] = coefficientPower[i][j];
			}
		}

		int[][] polynomialWithoutZero = NewPolynomial.mergeCommonPower(toTrim);
		polynomialWithoutZero = NewPolynomial.removeZero(polynomialWithoutZero);
		polynomialWithoutZero = NewPolynomial.sortPower(polynomialWithoutZero);

		this.coefficientPower = polynomialWithoutZero;

	}

	private static int[][] mergeCommonPower(int[][] toMerge) {
		for (int i = 0; i < toMerge[0].length; i++) {
			for (int j = i + 1; j < toMerge[0].length; j++) {
				if (toMerge[1][i] == toMerge[1][j]) {
					toMerge[0][i] += toMerge[0][j];
					toMerge[0][j] = 0;
				}
			}
		}
		return toMerge;
	}

	private static int[][] removeZero(int[][] arrayToTrim) {
		int count = 0;
		for (int i = 0; i < arrayToTrim[0].length; i++) {
			if (arrayToTrim[0][i] == 0) {
				count++;
			}
		}
		int[][] arrayToReturn = new int[2][arrayToTrim[0].length - count];

		for (int i = 0, j = 0; i < arrayToTrim[0].length && j < arrayToReturn[0].length; i++) {
			if (arrayToTrim[0][i] != 0) {
				arrayToReturn[0][j] = arrayToTrim[0][i];
				arrayToReturn[1][j] = arrayToTrim[1][i];
				j++;
			}
		}
		return arrayToReturn;
	}

	private static int[][] sortPower(int[][] arrayToSort) {
		for (int i = 0; i < arrayToSort[1].length; i++) {
			for (int j = i + 1; j < arrayToSort[1].length; j++) {
				if (arrayToSort[1][i] < arrayToSort[1][j]) {
					int temporary = arrayToSort[1][i];
					arrayToSort[1][i] = arrayToSort[1][j];
					arrayToSort[1][j] = temporary;
					temporary = arrayToSort[0][i];
					arrayToSort[0][i] = arrayToSort[0][j];
					arrayToSort[0][j] = temporary;
				}
			}
		}
		return arrayToSort;
	}

	public float evaluate(float valueOfX) {
		float result = 0;
		for (int i = 0; i < this.coefficientPower[0].length; i++) {
			result += coefficientPower[0][i] * Math.pow(valueOfX, coefficientPower[1][i]);
		}
		return result;
	}

	public void Display() {
		int i;
		for (i = 0; i < this.coefficientPower[0].length; i++) {
			if (i == 0) {
				System.out.printf("%dx^%d ", this.coefficientPower[0][i], this.coefficientPower[1][i]);
			} else {
				System.out.printf("%+dx^%d ", this.coefficientPower[0][i], this.coefficientPower[1][i]);
			}
		}
		System.out.println();

	}

	public int degreeOfPolynomial() {

		return this.coefficientPower[1][0];
	}

	public static NewPolynomial addPolyNomial(NewPolynomial firstPolynomial, NewPolynomial secondPolynomial) {
		int[][] first = firstPolynomial.getArray();
		int[][] second = secondPolynomial.getArray();
		int[][] afterAddition = new int[2][first[0].length + second[0].length];

		for (int i = 0; i < first[0].length; i++) {
			afterAddition[0][i] = first[0][i];
			afterAddition[1][i] = first[1][i];
		}
		for (int j = 0, k = first[0].length; j < second[0].length && k < afterAddition[0].length; j++) {
			afterAddition[1][k] = second[1][j];
			afterAddition[0][k] = second[0][j];
			k++;

		}
		afterAddition = NewPolynomial.mergeCommonPower(afterAddition);
		afterAddition = NewPolynomial.removeZero(afterAddition);
		return new NewPolynomial(afterAddition);
	}

	public static NewPolynomial multiplyPolynomial(NewPolynomial firstPolynomial, NewPolynomial secondPolynomial) {
		int [][]first = firstPolynomial.getArray();
		int [][]second = secondPolynomial.getArray();
		
		int size=(first[0].length * second[0].length );
		int[][] multipliedResult= new int[2][size];
		
		for(int i=0,k=0; i<first[0].length && k < multipliedResult[0].length;i++)
		{
			for(int j=0;j<second[0].length;j++)
			{
				multipliedResult[1][k]=second[1][j] + first[1][i];
				multipliedResult[0][k]=second[0][j]*first[0][i];
				k++;
			}
		}
		
		multipliedResult = NewPolynomial.mergeCommonPower(multipliedResult);
		multipliedResult = NewPolynomial.removeZero(multipliedResult);
		
		return new NewPolynomial(multipliedResult);
	}

	private int[][] getArray()
	{
		int[][] array = new int [2][this.coefficientPower[0].length];
		for(int i=0;i<this.coefficientPower[0].length;i++)
		{
				array[0][i] = this.coefficientPower[0][i];
				array[1][i] = this.coefficientPower[1][i];
		}
		return array;
	}
	
	public static void main(String args[]) {
		NewPolynomial poly1 = new NewPolynomial(new int[][] { { 8, 6, 5, 3 }, { 9, 7, 6, -4 } });
		poly1.Display();
		NewPolynomial poly2 = new NewPolynomial(new int[][] { { 5, 3, 2 }, { 6, 4, 3 } });
		poly2.Display();
		NewPolynomial polyadd = NewPolynomial.addPolyNomial(poly1, poly2);
		polyadd.Display();
		NewPolynomial polymul = NewPolynomial.multiplyPolynomial(poly1, poly2);
		polymul.Display();
		/*
		 * Polynomial polymul = Polynomial.multiplyPolynomial(poly1, poly2);
		 * polymul.Display();
		 */

	}
}