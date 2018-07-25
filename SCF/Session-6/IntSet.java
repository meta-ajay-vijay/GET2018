package Assignment7;

import java.util.ArrayList;
import java.util.Scanner;

import myUtility.inputValidation;

public final class IntSet {
	private final int[] integerArray;
	Scanner scan = new Scanner(System.in);

	public IntSet() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		System.out.print("Enter the size of set you want to insert: ");
		int size = IntSet.isPositiveInteger();

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			int element = IntSet.isIntegerInRange(1, 1000);
			if (!input.contains(new Integer(element))) {
				input.add(new Integer(element));
			}
		}

		integerArray = new int[input.size()];

		for (int i = 0; i < input.size(); i++) {
			integerArray[i] = input.get(i).intValue();
		}

	}

	/**
	 * Parameterized Constructor
	 * 
	 * Initialize integerArray
	 * 
	 * @param arrayToStore
	 */
	public IntSet(int[] arrayToStore) {
		Integer[] array1 = new Integer[arrayToStore.length];
		integerArray = new int[array1.length];
		for (int i = 0; i < arrayToStore.length; i++) {
			array1[i] = new Integer(arrayToStore[i]);
			integerArray[i] = array1[i].intValue();
		}
	}

	/**
	 * Takes only integer in input
	 * 
	 * @return choice integer value given by user
	 */
	private static int isInteger() {
		Scanner scanLocal = new Scanner(System.in);
		int choice = 0;
		boolean flag;
		do {
			flag = false;
			if (scanLocal.hasNextInt()) {
				choice = scanLocal.nextInt();
			} else {
				flag = true;
				System.out.println("Please enter a integer");
				scanLocal.next();
			}
		} while (flag);

		return choice;
	}

	/**
	 * Takes only positive integer in input
	 * 
	 * @return choice integer value given by user
	 */
	private static int isPositiveInteger() {
		boolean flag;
		int choice = 0;
		do {
			flag = false;
			try {
				choice = IntSet.isInteger();
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
	 * @return choice integer
	 */
	private static int isIntegerInRange(int start, int end) {
		int choice = 0;
		boolean flag;
		do {
			flag = false;
			try {
				choice = IntSet.isInteger();
				if (choice < start || choice > end) {
					throw new Exception("Please enter input between " + start + " and " + end);
				}
			} catch (Exception e) {
				flag = true;
				System.out.println(e.getMessage());
			}
		} while (flag);

		return choice;
	}

	/**
	 * Checks if the element given in parameter is a member of array. If yes
	 * return true else false.
	 * 
	 * @param elementToFind
	 * @return boolean variable temporary.
	 */
	public boolean isMember(int elementToFind) {
		Integer temporary = new Integer(elementToFind);
		boolean reply = false;
		for (int i = 0; i < integerArray.length; i++) {
			if (temporary.intValue() == (new Integer(integerArray[i]).intValue())) {
				reply = true;
				break;
			}
		}
		return reply;
	}

	public int size() {
		int length = integerArray.length;
		return length;
	}

	public boolean isSubSet(IntSet subset) {
		boolean reply = false;
		if (subset.integerArray.length <= this.integerArray.length) {
			IntSet temporarySet = new IntSet(subset.getArray());
			int i, j;
			for (i = 0, j = 0; i < integerArray.length && j < subset.getArray().length;) {
				if ((this.integerArray[i] == subset.integerArray[j])) {
					i++;
					j++;
				} else {
					i++;
					j = 0;
				}
			}
			if (j == subset.integerArray.length) {
				reply = true;
			}
		}
		return reply;
	}

	public IntSet getComplement() {
		ArrayList<Integer> temporary = new ArrayList<Integer>();
		for (int i = 0; i < this.integerArray.length; i++) {
			temporary.add(new Integer(this.integerArray[i]));
		}
		int[] toReturn = new int[(1000 - this.integerArray.length)];
		for (int i = 1, j = 0; i <= 1000 && j <= (1000 - this.integerArray.length); i++) {
			if (!this.isMember(i)) {
				toReturn[j++] = i;
			}
		}
		IntSet setToReturn = new IntSet(toReturn);
		return setToReturn;
	}

	public static IntSet Union(IntSet set1, IntSet set2) {
		int[] firstSetArray = new int[set1.integerArray.length];
		int[] secondSetArray = new int[set2.integerArray.length];
		for (int i = 0; i < firstSetArray.length; i++) {
			firstSetArray[i] = set1.integerArray[i];
		}
		ArrayList<Integer> unionSet = new ArrayList<Integer>();

		for (int i = 0; i < firstSetArray.length; i++) {
			unionSet.add(new Integer(firstSetArray[i]));
		}

		for (int i = 0; i < secondSetArray.length; i++) {
			secondSetArray[i] = set2.integerArray[i];
		}

		for (int i = 0; i < secondSetArray.length; i++) {
			if (!unionSet.contains(new Integer(secondSetArray[i]))) {
				unionSet.add(new Integer(secondSetArray[i]));
			}
		}

		for (int i = 0; i < secondSetArray.length; i++) {
			secondSetArray[i] = set2.integerArray[i];
		}
		int[] unionArray = new int[unionSet.size()];
		for (int i = 0; i < unionSet.size(); i++) {
			unionArray[i] = unionSet.get(i).intValue();
		}

		return new IntSet(unionArray);
	}

	private int[] getArray() {
		Integer[] temporary = new Integer[integerArray.length];
		int[] toReturn = new int[temporary.length];
		for (int i = 0; i < toReturn.length; i++) {
			temporary[i] = new Integer(integerArray[i]);
			toReturn[i] = temporary[i].intValue();
		}
		return toReturn;
	}

	public void Display() {
		for (int i = 0; i < this.integerArray.length; i++) {
			System.out.print(" " + this.integerArray[i]);
		}

	}
}