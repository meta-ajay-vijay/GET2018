package myUtility;

import java.util.*;

import employee.Employee;

/*import Assignment1.ShoppingCart.Cart;
 import Assignment1.ShoppingCart.customerSide;*/

public class Utility {

	static Scanner scan = new Scanner(System.in);

	public static boolean isValidPosition(String position) {
		boolean flag = true;
		for (int i = 0; i < position.length(); i++) {
			if (position.charAt(i) != 'T' && position.charAt(i) != 'H') {
				flag = false;
				break;
			}
		}
		return flag;
	}

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
	 * Checks whether entered input is in give range or not, If in range then accept
	 * otherwise do not
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
					throw new Exception("Please enter input between " + start + " and " + end);
				}
			} catch (Exception e) {
				flag = true;
				System.out.println(e.getMessage());
				// scan.next();
			}
		} while (flag);

		return choice;
	}

	public static int isValidEmployee(List<Employee> listOfEmployees) {
		int employeeId;
		boolean flag;
		do {
			flag = true;
			employeeId = isPositiveInt();
			if (listOfEmployees.size() >= 1) {
				for (int index = 0; index < listOfEmployees.size(); index++) {
					if (listOfEmployees.get(index).getEmpid() == employeeId) {
						flag = false;
						System.out.println("Employee Id already exists!\nPlease enter different employee id");
						break;
					}
				}
			}
		} while (!flag);
		return employeeId;
	}
}
