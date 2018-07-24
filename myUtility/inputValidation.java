package myUtility;

import Assignment1.ShoppingCart.Product;
import java.util.*;

/*import Assignment1.ShoppingCart.Cart;
 import Assignment1.ShoppingCart.customerSide;*/

public class inputValidation {

	static Scanner scan = new Scanner(System.in);

	/*
	 * public static boolean isString() {
	 * 
	 * }
	 */
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
				System.out.println("Please enter a valid integer input");
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
					throw new Exception("Please enter input between "+start+" and "+end);
				}
			} catch (Exception e) {
				flag = true;
				System.out.println(e.getMessage());
				// scan.next();
			}
		} while (flag);

		return choice;
	}

	/*
	 * public static int isIntRangeInclusive(int start, int end) { int flag,
	 * choice = 0; do {
	 * 
	 * try { choice = scan.nextInt(); if (choice < start || choice > end) { flag
	 * = 1; throw new Exception("Please enter input in given range"); } flag =
	 * 0; } catch (Exception e) { flag = 1; System.out.println(e.getMessage());
	 * 
	 * } } while (flag != 0);
	 * 
	 * return choice; }
	 */

	public static String isName() {
		int flag;
		String choice = new String();
		do {

			try {
				choice = scan.nextLine();
				for (int i = 0; i < choice.length(); i++) {
					if (!((choice.charAt(i) > 64 && choice.charAt(i) < 91)
							|| (choice.charAt(i) > 96 && choice.charAt(i) < 123) || choice
								.charAt(i) == ' ')) {
						flag = 1;
						throw new InputMismatchException();
					}
				}

				flag = 0;
			} catch (InputMismatchException e) {
				flag = 1;
				System.out.println("Please enter a valid input");
			}
		} while (flag != 0);

		return choice;
	}

	public static String isInBase() {
		int flag = 0;
		String inBase;
		do {
			inBase = scan.next();

			for (int i = 0; i < inBase.length(); i++) {
				if (!((inBase.charAt(i) >= '0' && inBase.charAt(i) <= '9')
						|| (inBase.charAt(i) >= 'a' && inBase.charAt(i) <= 'f') || (inBase
						.charAt(i) >= 'A' && inBase.charAt(i) <= 'F'))) {
					flag = 1;
					System.out
							.println("Please enter a valid hexadecimal number");
					break;
				} else {
					flag = 0;
				}
			}
		} while (flag != 0);

		return inBase;
	}

	public static int productAvailability(int pid, ArrayList<Product> plist) {
		int reply = -1;
		for (int i = 0; i < plist.size(); i++) {
			if (pid == plist.get(i).productId) {
				reply = i;
				break;
			}
		}

		return reply;
	}

	public static int productAvailabilityInCart(int pid,
			ArrayList<Product> plist) {
		int reply = -1;
		for (int i = 0; i < plist.size(); i++) {
			if (pid == plist.get(i).productId) {
				reply = i;
				break;
			}
		}

		return reply;
	}

}
