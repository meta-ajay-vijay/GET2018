package utility;

import java.util.*;

/*import Assignment1.ShoppingCart.Cart;
 import Assignment1.ShoppingCart.customerSide;*/

public class inputValidation {

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
				System.out.println("Please enter a integer");
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
					throw new Exception("Please enter index between "+start+" and "+end);
				}
			} catch (Exception e) {
				flag = true;
				System.out.println(e.getMessage());
				// scan.next();
			}
		} while (flag);

		return choice;
	}

}