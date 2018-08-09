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

	Map<String, BST> dictionaryMap = new HashedMap<String, BST>();
	List<String> wordsList = new ArrayList<String>();
	BST rootOfDictionary;

	/**
	 * method checks that word in BST object exists in dictionary or not, if exist
	 * then returns false and appropriate message, otherwise returns true
	 * 
	 * @param objectToAddInDictionary
	 * 
	 * @return object of booleanOrString
	 */
	public booleanAndString checkWordExistOrNot(BST objectToAddInDictionary) {
		booleanAndString resultOfInsertion = new booleanAndString();

		if (dictionaryMap.containsKey(objectToAddInDictionary.getKeyString())) {
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
		// If first entry in dictionary then make it root else add BST by recusion
		if (wordsList.size() == 0) {
			rootOfDictionary = objectToAddInDictionary;
			dictionaryMap.put(objectToAddInDictionary.getKeyString(), objectToAddInDictionary);
		} else {
			addInDictionaryByRecursion(objectToAddInDictionary, rootOfDictionary);
		}
	}

	private void addInDictionaryByRecursion(BST objectToAddInDictionary, BST bstValue) {

		if (bstValue.getKeyString().compareToIgnoreCase(objectToAddInDictionary.getKeyString()) < 0) {
			if (bstValue.getRightBST() == null) {
				bstValue.setRightBST(objectToAddInDictionary);
				dictionaryMap.put(bstValue.getKeyString(), bstValue);
			} else {
				addInDictionaryByRecursion(objectToAddInDictionary, bstValue.getRightBST());
			}
		} else if (bstValue.getKeyString().compareToIgnoreCase(objectToAddInDictionary.getKeyString()) > 0) {
			if (bstValue.getLeftBST() == null) {
				bstValue.setLeftBST(objectToAddInDictionary);
				dictionaryMap.put(bstValue.getKeyString(), bstValue);
			} else {
				addInDictionaryByRecursion(objectToAddInDictionary, bstValue.getLeftBST());
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
		// TODO Auto-generated method stub
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
		if(dictionaryMap.containsKey(keyInDictionary)) {
			resultToReturn.setFlag(true);
			resultToReturn.setMessage(dictionaryMap.get(keyInDictionary).getValueString());
		} else {
			resultToReturn.setFlag(false);
			resultToReturn.setMessage("No such word in dictionary");
		}
		return resultToReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#sortedDictionary()
	 */
	@Override
	public List<Dictionary> sortedDictionary() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#sortedDictionary(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Dictionary> sortedDictionary(String fromKey, String toKey) {
		// TODO Auto-generated method stub
		return null;
	}

}
