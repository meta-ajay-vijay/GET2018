package Assignment6.LCMHCF;

import java.util.Scanner;

public class LcmHcf {
	Scanner scan = new Scanner(System.in);

	/**
	 * Calculates Highest Common Divisor
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return integer variable reply
	 */
	public static int calculateHcf(int firstNumber, int secondNumber) {
		int reply;
		int remainder = firstNumber % secondNumber;

		if (remainder == 0) {
			return secondNumber;// Base condition
		} else {
			reply = calculateHcf(secondNumber, remainder);// Recursive call
		}

		return reply;
	}

	/**
	 * Find least common multiple of two numbers using prime factorization
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @param primeFactor
	 * @return integer variable reply
	 */
	public static int calculateLcm(int firstNumber, int secondNumber, int primeFactor) {
		int reply;
		if (secondNumber >= primeFactor) {
			if (firstNumber % primeFactor == 0 && secondNumber % primeFactor == 0) {
				reply = primeFactor * calculateLcm(firstNumber / primeFactor, secondNumber / primeFactor, primeFactor);// Recursive
																														// call
			} else {
				reply = calculateLcm(firstNumber, secondNumber, primeFactor + 1);// Recursive
																					// call
			}
		} else {
			return firstNumber * secondNumber;// Base condition
		}

		return reply;
	}

	static int reply;
	/**
	 * Find LCM 
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return integer variable toReturn
	 */
	public static int calculateLcmSimple(int firstNumber, int secondNumber) {
		int toReturn;
		boolean flag = true;
		do {
			if (reply % firstNumber == 0 && reply % secondNumber == 0) {
				flag = false;
				toReturn = reply;
			} else {
				reply++;
				toReturn = calculateLcmSimple(firstNumber, secondNumber);
			}
		} while (flag);
		return toReturn;
	}
	
}