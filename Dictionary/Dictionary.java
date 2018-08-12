package Dictionary;

import java.util.List;

/**
 * @author User1
 *
 */
public interface Dictionary {

	/**
	 * Insert an entry in dictionary
	 * 
	 * @param objectToAddInDictionary
	 *            entry to add in dictionary
	 * @return true if object successfully added in dictionary, Otherwise false.
	 */
	public void addInDictionary(BST objectToAddInDictionary);

	/**
	 * Delete an entry from dictionary
	 * 
	 * @param objectToDeleteFromDictionary
	 *            entry to delete from dictionary
	 * 
	 * @return true if object successfully deleted from dictionary, Otherwise
	 *         false.
	 */
	public booleanAndString deleteFromDictionary(String wordToDelete, BST parentNode);

	/**
	 * Get the value from dictionary
	 * 
	 * @param keyInDictionary
	 * 
	 * @return value corresponding to the keyInDictionary
	 */
	public booleanAndString getValueFromDictionary(String keyInDictionary);

	/**
	 * Sort dictionary by key
	 * 
	 * @return List of sorted dictionary elements
	 */
	public List<BST> sortedDictionary(BST parentNode);

	/**
	 * return sorted dictionary from fromKey(inclusive) to toKey (inclusive)
	 * 
	 * @param fromKey
	 * @param toKey
	 * 
	 * @return List of sorted dictionary elements in specified range
	 *//*
	public List<BST> sortedDictionary(String fromKey, String toKey, BST currentNode);*/
}
