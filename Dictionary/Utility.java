package Dictionary;

import java.util.*;

import employee.Employee;

/*import Assignment1.ShoppingCart.Cart;
 import Assignment1.ShoppingCart.customerSide;*/

public class Utility {

	static Scanner scan = new Scanner(System.in);

	/**
	 * Checks whether entered input is of integer type or not
	 * 
	 * @return integer type variable choice
	 */
	public static int isInt() {
		int choice = 0;
		boolean flag;
		do {
			flag = false;
			if (scan.hasNextInt()) {
				choice = scan.nextInt();
			} else {
				flag = true;
				System.out.println("Please enter an integer");
				scan.next();
			}
		} while (flag);

		return choice;
	}

	/**
	 * Checks whether entered input is of positive integer or not
	 * 
	 * @return integer variable choice
	 */
	public static int isPositiveInt() {
		boolean flag;
		int choice = 0;
		do {
			flag = false;
			try {
				choice = isInt();
				if (choice <= 0) {
					throw new Exception("Please Enter Positive Number");
				}

			} catch (Exception e) {
				flag = true;
				System.out.println(e.getMessage());
			}
		} while (flag);

		return choice;
	}

	/**
	 * 
	 * Checks whether entered input is in give range or not, If in range then
	 * accept otherwise do not
	 * 
	 * @param start
	 * @param end
	 * @return integer variable choice
	 */
	public static int isIntInRange(int start, int end) {
		int choice = 0;
		boolean flag;
		do {
			flag = false;
			try {
				choice = isInt();
				if (choice < start || choice > end) {
					throw new Exception("Please enter an integer between " + start + " and " + end);
				}
			} catch (Exception e) {
				flag = true;
				System.out.println(e.getMessage());
				// scan.next();
			}
		} while (flag);

		return choice;
	}

	/**
	 * 
	 * @return
	 */
	public static String isAWord() {
		boolean flag;
		Scanner scanForLine = new Scanner(System.in);
		String choice = new String();
		do {
			flag = false;
			if (scanForLine.hasNext()) {
				choice = scanForLine.nextLine();
				for (int i = 0; i < choice.length(); i++) {
					if (!((choice.charAt(i) > 64 && choice.charAt(i) < 91)
							|| (choice.charAt(i) > 96 && choice.charAt(i) < 123) || choice.charAt(i) == ' ')) {
						flag = true;
						break;
					}
				}
			} else {
				flag = true;
			}
		} while (flag);

		return choice;
	}

	/**
	 * 
	 * @return
	 */
	public static String isAMeaning() {
		boolean flag;
		Scanner scanForLine = new Scanner(System.in);
		String choice = new String();
		do {
			flag = false;
			if (scanForLine.hasNextLine() || scanForLine.hasNext()) {
				choice = scanForLine.nextLine();
				for (int i = 0; i < choice.length(); i++) {
					if (!((choice.charAt(i) > 64 && choice.charAt(i) < 91)
							|| (choice.charAt(i) > 96 && choice.charAt(i) < 123) || choice.charAt(i) == ' ')) {
						flag = true;
						break;
					}
				}
			} else {
				flag = true;
			}
		} while (flag);

		return choice;
	}

}
