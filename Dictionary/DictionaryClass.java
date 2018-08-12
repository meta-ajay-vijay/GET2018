/**
 * 
 */
package Dictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;

/**
 * @author User1
 *
 */
public class DictionaryClass implements Dictionary {

	// list to store all the words that are in dictionary
	static List<String> wordsList = new ArrayList<String>();
	BST rootOfDictionary;
	JSONObject initialEntriesInDictionary;

	public DictionaryClass(JSONObject initialEntriesInDictionary) {
		this.initialEntriesInDictionary = initialEntriesInDictionary;
		for (Object key : this.initialEntriesInDictionary.keySet()) {
			String word = (String) key;
			String meaning = (String) this.initialEntriesInDictionary.get(key);
			BST wordToAddInDictionary = new BST(word, meaning);
			if (this.checkWordExistOrNot(word).getFlag()) {
				this.addInDictionary(wordToAddInDictionary);
			}
			else {
				System.out.println("Word " + wordToAddInDictionary.toString() + " already exist.");
			}
		}
	}

	/**
	 * method checks that word in BST object exists in dictionary or not, if exist
	 * then returns false and appropriate message, otherwise returns true
	 * 
	 * @param objectToAddInDictionary
	 * 
	 * @return object of booleanOrString
	 */
	public booleanAndString checkWordExistOrNot(String wordToAddInDictionary) {
		booleanAndString resultOfInsertion = new booleanAndString();

		// checks if the word is in the list of words or not
		if (wordsList.contains(wordToAddInDictionary.toUpperCase())) {
			resultOfInsertion.setFlag(false);
			resultOfInsertion.setMessage("Word already exist in dictionary");
		} else {
			resultOfInsertion.setFlag(true);
			resultOfInsertion.setMessage("Operation is successfully completed");
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
		// recursion
		if (rootOfDictionary == null) {
			rootOfDictionary = objectToAddInDictionary;
			rootOfDictionary.setParent(null);
			System.out.println("Root");
			wordsList.add(objectToAddInDictionary.getKeyString().toUpperCase());
			// dictionaryMap.put(objectToAddInDictionary.getKeyString(),
			// objectToAddInDictionary);
		} else {
			// Call to another function
			addInDictionaryByRecursion(objectToAddInDictionary, rootOfDictionary);

		}
	}

	/**
	 * 
	 * @param objectToAddInDictionary Word that we want to add in dictionary
	 * @param currentNode
	 */
	private void addInDictionaryByRecursion(BST objectToAddInDictionary, BST currentNode) {
		// when the current word is smaller than the word that we want to add in
		// dictionary
		if (objectToAddInDictionary.getKeyString().compareToIgnoreCase(currentNode.getKeyString()) > 0) {
			if (currentNode.getRightBST() == null) {
				objectToAddInDictionary.setParent(currentNode);
				currentNode.setRightBST(objectToAddInDictionary);
				wordsList.add(objectToAddInDictionary.getKeyString().toUpperCase());
				System.out.println("Added to Right");
				return;
			} else {
				System.out.println("Going to the Right...");
				addInDictionaryByRecursion(objectToAddInDictionary, currentNode.getRightBST()); // Recursive call
				return;
			}
		}
		// when the current word is greater than the word that we want to add in
		// dictionary
		else if (objectToAddInDictionary.getKeyString().compareToIgnoreCase(currentNode.getKeyString()) < 0) {
			if (currentNode.getLeftBST() == null) {
				objectToAddInDictionary.setParent(currentNode);
				currentNode.setLeftBST(objectToAddInDictionary);
				wordsList.add(objectToAddInDictionary.getKeyString().toUpperCase());
				System.out.println("Added to Left");
				return;
			} else {
				System.out.println("Going to the Left...");
				addInDictionaryByRecursion(objectToAddInDictionary, currentNode.getLeftBST()); // Recursive call
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
	public booleanAndString deleteFromDictionary(String wordToDelete, BST currentNode) {
		booleanAndString resultToReturn = new booleanAndString();
		// When we are at the word that we want to delete
		if (currentNode.getKeyString().compareToIgnoreCase(wordToDelete) == 0) {
			// delete the root node
			if (currentNode.compareTo(rootOfDictionary) == 0) {
				// when there is no left child
				if (currentNode.getLeftBST() == null && currentNode.getRightBST() != null) {
					resultToReturn.setFlag(true);
					resultToReturn.setMessage("Word " + currentNode.toString() + " is deleted.");
					wordsList.remove(currentNode.getKeyString());
					rootOfDictionary = rootOfDictionary.getRightBST();
				}
				// when there is no right child
				else if (currentNode.getLeftBST() != null && currentNode.getRightBST() == null) {
					resultToReturn.setFlag(true);
					resultToReturn.setMessage("Word " + currentNode.toString() + " is deleted.");
					wordsList.remove(currentNode.getKeyString());
					rootOfDictionary = rootOfDictionary.getLeftBST();
				}
				// when there is no child
				else if (currentNode.getLeftBST() == null && currentNode.getRightBST() == null) {
					resultToReturn.setFlag(true);
					resultToReturn
							.setMessage("Word " + currentNode.toString() + " is deleted.\n Now dictionary is empty.");
					wordsList.remove(currentNode.getKeyString());
					rootOfDictionary = null;
				} else if (currentNode.getLeftBST() != null && currentNode.getRightBST() != null) {
					wordsList.remove(currentNode.getKeyString());
					resultToReturn.setFlag(true);
					resultToReturn.setMessage("Word " + currentNode.toString() + " is deleted.");
					addInDictionaryByRecursion(currentNode.getLeftBST(), currentNode.getRightBST());
					rootOfDictionary = rootOfDictionary.getRightBST();
				}
			}
			// when the word we are deleting is not at the root
			else {
				resultToReturn.setFlag(true);
				resultToReturn.setMessage(currentNode.getKeyString());
				// when there is a left child
				if (currentNode.getLeftBST() != null) {
					// when there is a right child too
					if (currentNode.getRightBST() != null) {
						// when word we want to delete has both left and right child,
						// add left child to the right child
						addInDictionaryByRecursion(currentNode.getLeftBST(), currentNode.getRightBST());
						// deleting the word
						if (currentNode.getParent().getLeftBST().getKeyString().equals(wordToDelete)) {
							// removing the word from the list of words
							wordsList.remove(currentNode.getKeyString());
							currentNode.getParent().setLeftBST(currentNode.getRightBST());
						} else if (currentNode.getParent().getRightBST().getKeyString().equals(wordToDelete)) {
							// removing the word from the list of words
							wordsList.remove(currentNode.getKeyString());
							currentNode.getParent().setRightBST(currentNode.getRightBST());
						}
					}
					// when there is a no right child
					else {
						if (currentNode.getParent().getLeftBST().getKeyString().equals(wordToDelete)) {
							wordsList.remove(currentNode.getKeyString());
							currentNode.getParent().setLeftBST(currentNode.getLeftBST());
						} else if (currentNode.getParent().getRightBST().getKeyString().equals(wordToDelete)) {
							wordsList.remove(currentNode.getKeyString());
							currentNode.getParent().setRightBST(currentNode.getLeftBST());
						}
					}
				}
				// when we want to delete word at leaf node
				else if (currentNode.getLeftBST() == null && currentNode.getRightBST() == null) {
					if (currentNode.getParent().getLeftBST() != null
							&& currentNode.getParent().getLeftBST().getKeyString().equals(wordToDelete)) {
						// removing the word from the list of words
						wordsList.remove(currentNode.getKeyString());
						currentNode.getParent().setLeftBST(null);
					} else if (currentNode.getParent().getRightBST() != null
							&& currentNode.getParent().getRightBST().getKeyString().equals(wordToDelete)) {
						// removing the word from the list of words
						wordsList.remove(currentNode.getKeyString());
						currentNode.getParent().setRightBST(null);
					}
				}

			}
		} else if (currentNode.getKeyString().compareToIgnoreCase(wordToDelete) > 0
				&& currentNode.getLeftBST() != null) {
			resultToReturn = deleteFromDictionary(wordToDelete, currentNode.getLeftBST()); // Recursive call
		} else if (currentNode.getKeyString().compareToIgnoreCase(wordToDelete) < 0
				&& currentNode.getRightBST() != null) {
			resultToReturn = deleteFromDictionary(wordToDelete, currentNode.getRightBST()); // Recursive call
		}

		return resultToReturn;
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
		if (parentNode.getLeftBST() != null) {
			listToAddInSortedOrder.addAll(sortedDictionary(parentNode.getLeftBST()));
		}
		listToAddInSortedOrder.add(parentNode);
		if (parentNode.getRightBST() != null) {
			listToAddInSortedOrder.addAll(sortedDictionary(parentNode.getRightBST()));
		}
		return listToAddInSortedOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dictionary.Dictionary#sortedDictionary(java.lang.String,
	 * java.lang.String)
	 * 
	 * @Override public List<BST> sortedDictionary(String fromKey, String toKey, BST
	 * currentNode) { List<BST> listToAddInSortedOrder = new ArrayList<BST>(); if
	 * (currentNode.getLeftBST() != null &&
	 * currentNode.getKeyString().compareToIgnoreCase(fromKey) > 0) {
	 * listToAddInSortedOrder.addAll(sortedDictionary(fromKey, toKey,
	 * currentNode.getLeftBST())); if
	 * (currentNode.getKeyString().compareToIgnoreCase(fromKey) > 0) {
	 * listToAddInSortedOrder.add(currentNode); } }
	 * 
	 * if (currentNode.getRightBST() != null &&
	 * currentNode.getKeyString().compareToIgnoreCase(fromKey) < 0) {
	 * listToAddInSortedOrder.addAll(sortedDictionary(fromKey, toKey,
	 * currentNode.getRightBST())); } return listToAddInSortedOrder; }
	 */

}
