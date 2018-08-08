package myUtility;

import java.util.*;

/*import Assignment1.ShoppingCart.Cart;
 import Assignment1.ShoppingCart.customerSide;*/

public class Utility {

	static Scanner scan = new Scanner(System.in);

	public static boolean isValidPosition(List<Object> listToCheck, String position) {
		boolean flag = true;
		for (int i = 0; i < position.length(); i++) {
			if (position.charAt(i) != 'T') {
				if (position.charAt(i) != 'H') {
					flag = false;
					break;
				}

			}
		}

		if (flag) {
			flag = checkIfThereIsIntegerAtPosition(listToCheck, position);
		}
		return flag;
	}

	public static boolean checkIfThereIsIntegerAtPosition(List<Object> listToCheck, String position) {
		boolean flag = true;
		for (int indexOfList = 0; indexOfList < position.length(); indexOfList++) {
			if (position.charAt(indexOfList) == 'T') {
				if (listToCheck.size() > 1) {
					if (listToCheck.subList(1, listToCheck.size()).size() == 1) {
						if (listToCheck.subList(1, listToCheck.size()).get(0) instanceof String) {
							if (indexOfList < position.length() - 1) {
								flag = false;
								break;
							}
						} else {
							flag = checkIfThereIsIntegerAtPosition(listToCheck.subList(1, listToCheck.size()),
									position.substring(indexOfList));
						}

					} else {
						flag = checkIfThereIsIntegerAtPosition(listToCheck.subList(1, listToCheck.size()),
								position.substring(indexOfList));
					}

				}
			} else {
				if (listToCheck.get(0) instanceof String) {
					if (indexOfList < position.length() - 1) {
						flag = false;
					}

				} else if (listToCheck.get(0) instanceof List) {
					flag = checkIfThereIsIntegerAtPosition((List) listToCheck.get(0), position.substring(indexOfList));
				}

			}
		}

		return flag;
	}
}
