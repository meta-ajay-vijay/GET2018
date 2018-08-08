package nestedList;

import java.util.List;

/**
 * @author User1
 *
 */
public interface NestedListOfIntegersInterface {
	
	/**
	 * calculate and return sum of all integers in list
	 * 
	 * @return sum of all integer elements in list
	 */
	public int sumOfAllIntegersInList(List<Object> list);
	
	/**
	 * find and return largest integer in the list 
	 * 
	 * @return largest integer in the list
	 */
	public int largestIntegerInList(List<Object> nestedList);
	
	/**
	 * find element given by user in list
	 * 
	 * @param integerUserWantToFind integer value user want to find in the list
	 * 
	 * @return boolean value true if element is in list, otherwise false
	 */
	public boolean findIntegerInList(List<Object> nestedList, int integerUserWantToFind);
}
