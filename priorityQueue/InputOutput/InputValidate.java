package priorityQueue.InputOutput;

import java.util.*;

public class InputValidate {

	/**
	 * Takes Input from the user which is an Integer.
	 * 
	 * @return Integer value.
	 */
	public static int isInt() {
		int integerValue = 0;
		Scanner scan = new Scanner(System.in);
		boolean flag;
		do {
			flag = false;
			if (scan.hasNextInt()) {
				integerValue = scan.nextInt();
			} else {
				flag = true;
				System.out.println("Please enter a Integer numeric value");
				scan.next();
			}
		} while (flag);
		return integerValue;
	}

	/**
	 * Takes Input as an positive Integer.
	 * 
	 * @return Positive Integer Value.
	 */
	public static int isPositiveInt() {
		int integerValue = -1;
		boolean flag;
		do {
			flag = false;
			try {
				integerValue = isInt();
				if (integerValue <= 0) {
					throw new Exception("Integer is Negative");
				}
			} catch (Exception e) {
				flag = true;
				System.out.println("Please enter a non negative Integer.");
			}
		} while (flag);
		return integerValue;
	}

	/**
	 * Takes input of Positive Integer in a specified range (inclusive).
	 * 
	 * @param start
	 * @param end
	 * @return Integer Value in specified range.
	 */
	public static int isPositiveIntRange(int start, int end) {
		int integerValue = -1;
		boolean flag;
		do {
			flag = false;
			try {
				integerValue = isPositiveInt();
				if (integerValue < start || integerValue > end) {
					throw new Exception("Integer is not in required specific Range");
				}
			} catch (Exception e) {
				flag = true;
				System.out.println("Please enter the Integer in the required specific range");
			}
		} while (flag);
		return integerValue;
	}

	/**
	 * Checks the input is y or n.
	 * 
	 * @param checkVariable
	 * @param checkVariable2
	 * @return Char Variable.
	 */
	public static char isCharFromTwo(char checkVariable, char checkVariable2) {
		char charVariable = '!';
		Scanner scanChar = new Scanner(System.in);
		boolean flag;
		do {
			flag = false;
			try {
				charVariable = scanChar.next().charAt(0);
				if (charVariable != checkVariable && charVariable != checkVariable2) {
					throw new Exception("Please enter a valid command");
				}
			} catch (Exception e) {
				flag = true;
				e.getMessage();
			}
		} while (flag);
		return charVariable;
	}
}