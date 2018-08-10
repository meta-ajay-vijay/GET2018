/**
 * 
 */
package Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;

/**
 * @author User1
 *
 */
public class DictionaryClass implements Dictionary {

	// Map<String, BST> dictionaryMap = new HashedMap<String, BST>();
	static List<String> wordsList = new ArrayList<String>();
	BST rootOfDictionary;

	/**
	 * method checks that word in BST object exists in dictionary or not, if
	 * exist then returns false and appropriate message, otherwise returns true
	 * 
	 * @param objectToAddInDictionary
	 * 
	 * @return object of booleanOrString
	 */
	public booleanAndString checkWordExistOrNot(BST objectToAddInDictionary) {
		booleanAndString resultOfInsertion = new booleanAndString();

		if (wordsList.contains(objectToAddInDictionary.getKeyString().toUpperCase())) {
			resultOfInsertion.setFlag(false);
			resultOfInsertion.setMessage("Word already exist in dictionary");
		} else {
			resultOfInsertion.setFlag(true);
			resultOfInsertion.setMessage("Word successfully added in dictionary");
		}

		return resultOfInsertion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#entryInDictionary(Dictionary.Dictionary)
	 */
	@Override
	public void addInDictionary(BST objectToAddInDictionary) {
		// If first entry in dictionary then make it root else add BST by
		// recusion
		if (rootOfDictionary == null) {
			rootOfDictionary = objectToAddInDictionary;
			rootOfDictionary.setParent(null);
			System.out.println("Root");
			wordsList.add(objectToAddInDictionary.getKeyString().toUpperCase());
			// dictionaryMap.put(objectToAddInDictionary.getKeyString(),
			// objectToAddInDictionary);
		} else {
			addInDictionaryByRecursion(objectToAddInDictionary, rootOfDictionary);

		}
	}

	/**
	 * 
	 * @param objectToAddInDictionary
	 *            Word that we want to add in dictionary
	 * @param bstValue
	 */
	private void addInDictionaryByRecursion(BST objectToAddInDictionary, BST bstValue) {

		if (objectToAddInDictionary.getKeyString().compareToIgnoreCase(bstValue.getKeyString()) > 0) {
			if (bstValue.getRightBST() == null) {
				objectToAddInDictionary.setParent(bstValue);
				bstValue.setRightBST(objectToAddInDictionary);
				wordsList.add(objectToAddInDictionary.getKeyString().toUpperCase());
				// dictionaryMap.put(bstValue.getKeyString(), bstValue);
				System.out.println("Added to Right");
				return;
			} else {
				System.out.println("Going to the Right...");
				addInDictionaryByRecursion(objectToAddInDictionary, bstValue.getRightBST());
				return;
			}
		} else if (objectToAddInDictionary.getKeyString().compareToIgnoreCase(bstValue.getKeyString()) < 0) {
			if (bstValue.getLeftBST() == null) {
				objectToAddInDictionary.setParent(bstValue);
				bstValue.setLeftBST(objectToAddInDictionary);
				// dictionaryMap.put(bstValue.getKeyString(), bstValue);
				wordsList.add(objectToAddInDictionary.getKeyString().toUpperCase());
				System.out.println("Added to Left");
				return;
			} else {
				System.out.println("Going to the Left...");
				addInDictionaryByRecursion(objectToAddInDictionary, bstValue.getLeftBST());
				return;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#deleteFromDictionary(Dictionary.Dictionary)
	 */
	@Override
	public boolean deleteFromDictionary(String wordToDelete) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#getValueFromDictionary(java.lang.String)
	 */
	@Override
	public booleanAndString getValueFromDictionary(String keyInDictionary) {
		booleanAndString resultToReturn = new booleanAndString();
		if (wordsList.size() > 1) {
			resultToReturn = getValueByRecursion(keyInDictionary, rootOfDictionary);
		} else {
			if (rootOfDictionary == null) {
				resultToReturn.setFlag(false);
				resultToReturn.setMessage("Nothing in dictionary");
			} else {
				if (rootOfDictionary.getKeyString().equals(keyInDictionary)) {
					resultToReturn.setFlag(true);
					resultToReturn.setMessage("Found");
				} else {
					resultToReturn.setFlag(false);
					resultToReturn.setMessage("NotFound");
				}
			}
		}

		return resultToReturn;
	}

	public booleanAndString getValueByRecursion(String keyInDictionary, BST parentOfKeyBeingSearched) {
		booleanAndString resultToReturn = new booleanAndString();

		if (parentOfKeyBeingSearched.getLeftBST() == null && parentOfKeyBeingSearched.getRightBST() == null) {
			if (!parentOfKeyBeingSearched.getKeyString().equals(keyInDictionary)) {
				resultToReturn.setFlag(false);
				resultToReturn.setMessage("Word not found");
			}
		}
		if (parentOfKeyBeingSearched.getKeyString().compareToIgnoreCase(keyInDictionary) == 0) {
			resultToReturn.setFlag(true);
			resultToReturn.setMessage(parentOfKeyBeingSearched.getValueString());

		} else if (parentOfKeyBeingSearched.getKeyString().compareToIgnoreCase(keyInDictionary) < 0) {
			resultToReturn = getValueByRecursion(keyInDictionary, parentOfKeyBeingSearched.getRightBST());

		} else if (parentOfKeyBeingSearched.getKeyString().compareToIgnoreCase(keyInDictionary) > 0) {
			resultToReturn = getValueByRecursion(keyInDictionary, parentOfKeyBeingSearched.getLeftBST());

		}

		return resultToReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#sortedDictionary()
	 */
	@Override
	public List<BST> sortedDictionary(BST parentNode) {
		List<BST> listToAddInSortedOrder = new ArrayList<BST>();
		if(parentNode.getLeftBST() != null){
			listToAddInSortedOrder.addAll(sortedDictionary(parentNode.getLeftBST()));
		}
		listToAddInSortedOrder.add(parentNode);
		if(parentNode.getRightBST() != null){
			listToAddInSortedOrder.addAll(sortedDictionary(parentNode.getRightBST()));
		}
		return listToAddInSortedOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#sortedDictionary(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Dictionary> sortedDictionary(String fromKey, String toKey) {
		return null;
	}

}
