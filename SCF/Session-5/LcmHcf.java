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
		System.out.println(remainder);
		if (remainder == 0) {
			return secondNumber;
		} else {
			reply = calculateHcf(secondNumber, remainder);
		}

		return reply;
	}

	/*public static int calculateLcm(int firstNumber, int secondNumber) {
		int reply = 1, i;
		for (i = 2; i <= firstNumber; i++) {
			if ((firstNumber % i == 0) && (secondNumber % i == 0)) {
				reply = i * calculateLcm(firstNumber / i, secondNumber / i);
				break;
			}
		}
		if (i == firstNumber + 1) {
			reply = firstNumber * secondNumber;
		}
		return reply;
	}*/

	/**
	 * Findlcmof two numbers
	 * @param firstNumber
	 * @param secondNumber
	 * @param primeFactor
	 * @return integer variable reply
	 */
	public static int calculateLcm(int firstNumber, int secondNumber, int primeFactor) {
		int reply;
		if (secondNumber >= primeFactor) {
			if (firstNumber % primeFactor == 0 && secondNumber % primeFactor == 0) {
				reply = primeFactor * calculateLcm(firstNumber / primeFactor, secondNumber / primeFactor, primeFactor);
			} else {
				reply = calculateLcm(firstNumber, secondNumber, primeFactor + 1);
			}
		} else {
			return firstNumber * secondNumber;
		}

		return reply;
	}
}