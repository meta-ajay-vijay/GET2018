package nestedList;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;

import myUtility.Utility;

/**
 * @author User1
 *
 */
public class NestedListOfIntegers implements NestedListOfIntegersInterface {

	List<Object> listOfIntegersFinal = new LinkedList<Object>();

	static int largestIntegerInList = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see nestedList.NestedListOfIntegersInterface#sumOfAllIntegersInList()
	 */
	@Override
	public int sumOfAllIntegersInList(List<Object> nestedList) {
		int sumOfList = 0;
		for (int index = 0; index < nestedList.size(); index++) {
			if (nestedList.get(index) instanceof String) {
				sumOfList += Integer.parseInt((String) nestedList.get(index));

			} else if (nestedList.get(index) instanceof List) {
				sumOfList += sumOfAllIntegersInList((List) nestedList.get(index));
			}
		}

		return sumOfList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nestedList.NestedListOfIntegersInterface#largestIntegerInList()
	 */
	@Override
	public int largestIntegerInList(List<Object> nestedList) {
		for (int index = 0; index < nestedList.size(); index++) {
			if (nestedList.get(index) instanceof String) {
				if (Integer.parseInt((String) nestedList.get(index)) > largestIntegerInList) {
					largestIntegerInList = Integer.parseInt((String) nestedList.get(index));
				}
			} else if (nestedList.get(index) instanceof List) {
				largestIntegerInList = largestIntegerInList((List) nestedList.get(index));
			}
		}

		return largestIntegerInList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nestedList.NestedListOfIntegersInterface#findIntegerInList(java.lang.
	 * Integer)
	 */
	@Override
	public boolean findIntegerInList(List<Object> nestedList, int integerUserWantToFind) {
		boolean flag = false;
		for (int index = 0; index < nestedList.size(); index++) {
			if (nestedList.get(index) instanceof String) {
				if (Integer.parseInt((String) nestedList.get(index)) == integerUserWantToFind) {
					flag = true;
					break;
				}
			} else if (nestedList.get(index) instanceof List) {
				flag = findIntegerInList((List) nestedList.get(index), integerUserWantToFind);
				if (flag) {
					break;
				}
			}
		}

		return flag;
	}

	private boolean isInteger(String stringToCheckIfItIsInteger) {
		boolean flag = true;
		for (int index = 0; index < stringToCheckIfItIsInteger.length(); index++) {
			if (stringToCheckIfItIsInteger.charAt(index) < 48 || stringToCheckIfItIsInteger.charAt(index) > 57) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * 
	 * 
	 * @param listOfIntegers
	 * @param inputArray
	 * 
	 * @return
	 */
	public List<Object> createNestedList(List<Object> listOfIntegers, JSONArray inputArray) {
		int lengthOfList = inputArray.size();

		for (int indexOfList = 0; indexOfList < lengthOfList; indexOfList++) {
			if (inputArray.get(indexOfList) instanceof String) {
				if (isInteger((String) inputArray.get(indexOfList))) {
					listOfIntegers.add(inputArray.get(indexOfList));
				}
			} else if (inputArray.get(indexOfList) instanceof List) {
				List<Object> branchList = new LinkedList<Object>();
				listOfIntegers.add(createNestedList(branchList, (JSONArray) inputArray.get(indexOfList)));
			}
		}

		return listOfIntegers;
	}

	/**
	 * 
	 * @param listToPrint
	 */
	public void printNestedList(List<Object> listToPrint) {
		System.out.print("[ ");
		for (int index = 0; index < listToPrint.size(); index++) {
			if (listToPrint.get(index) instanceof String) {
				if (index == listToPrint.size() - 1) {
					System.out.print(listToPrint.get(index) + " ");
				} else {
					System.out.print(listToPrint.get(index) + ", ");
				}

			} else if (listToPrint.get(index) instanceof List) {
				printNestedList((List) listToPrint.get(index));
				if (index != listToPrint.size() - 1) {
					System.out.print(", ");
				} else {
					System.out.print(" ");
				}

			}
		}
		System.out.print("]");
	}

	/*
	 * public int getvalue(String position, List<Object> nestedList) { int
	 * integerToReturn; for (int index = 0; index < position.length(); index++)
	 * { if (position.charAt(index) == 'H') { if (nestedList.get(0) instanceof
	 * String) { if (index < position.length() - 1) { throw new
	 * AssertionError("Error!"); } else {
	 * 
	 * }
	 * 
	 * } else if (nestedList.get(0) instanceof List) {
	 * 
	 * }
	 * 
	 * } else if (position.charAt(index) == 'T') {
	 * 
	 * } }
	 * 
	 * return integerToReturn; }
	 */
}
