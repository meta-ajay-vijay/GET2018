/**
 * 
 */
package Dictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author User1
 *
 */
public class DictionaryMain {
	public static final String initialDictionaryEntriesPath = "H:\\Akv\\Eclipse\\Data Structure\\src\\Dictionary\\initialDictionaryEntries.json";

	/**
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		int choice;
		Object object = new JSONParser().parse(new FileReader(initialDictionaryEntriesPath));
		JSONObject inputJsonObject = (JSONObject) object;
		DictionaryClass dictionary = new DictionaryClass(inputJsonObject);

		do {
			System.out.println("\n*************DICTIONARY*************");
			System.out.println("Press 1 if you want to add a word in dictionary");
			System.out.println("Press 2 if you want to delete a word from dictionary");
			System.out.println("Press 3 if you want to know meaning of a word");
			System.out.println("Press 4 if you want sorted dictionary");
			System.out.println("Press 5 if you want sorted words from dictionary that exist between two words");
			System.out.println("Press 6 if you want to exit");

			System.out.println("\nPlease select the operation you want to perform");

			choice = Utility.isIntInRange(1, 6);

			switch (choice) {
			case 1:
				System.out.println("Enter the word");
				String word = Utility.isAWord();
				System.out.println("Enter the meaning of word");
				String meaningOfWord = Utility.isAMeaning();

				BST wordToAddInDictionary = new BST(word, meaningOfWord);
				booleanAndString checkResultOfInsertion = dictionary.checkWordExistOrNot(word);

				if (checkResultOfInsertion.getFlag()) {
					dictionary.addInDictionary(wordToAddInDictionary);
					System.out.println(checkResultOfInsertion.getMessage());
				} else {
					System.out.println(checkResultOfInsertion.getMessage());
				}
				break;

			case 2:
				System.out.println("Enter the word you want to delete");
				String wordToDelete = Utility.isAWord();
				booleanAndString resultOfDelete = dictionary.checkWordExistOrNot(wordToDelete);

				if (!resultOfDelete.getFlag()) {
					System.out.println("Deleted word is ");
					System.out.println(
							dictionary.deleteFromDictionary(wordToDelete, dictionary.rootOfDictionary).getMessage());
				} else {
					System.out.println("There is no such word in dictionary");
				}

				break;

			case 3:
				System.out.println("Enter the word");
				String wordWhichMeaningUserWantToKnow = Utility.isAWord();

				booleanAndString doesExist = dictionary.checkWordExistOrNot(wordWhichMeaningUserWantToKnow);
				if (!doesExist.getFlag()) {
					booleanAndString result = dictionary.getValueFromDictionary(wordWhichMeaningUserWantToKnow);
					System.out.println("Meaning of word is");
					System.out.println(result.getMessage());
				} else {
					System.out.println("Word does not exist.");
				}

				break;

			case 4:
				if (dictionary.rootOfDictionary != null) {
					List<BST> sortedWordsFromDictionary = dictionary.sortedDictionary(dictionary.rootOfDictionary);
					for (int index = 0; index < sortedWordsFromDictionary.size(); index++) {
						System.out.println(sortedWordsFromDictionary.get(index).toString());
					}
				} else {
					System.out.println("Dictionary is empty!");
				}
				break;

			case 5:
				if (dictionary.rootOfDictionary != null) {
					System.out.println("Enter the first word");
					String startingWord = Utility.isAWord();
					booleanAndString firstWordExistOrNot = dictionary.checkWordExistOrNot(startingWord);
					if (!firstWordExistOrNot.getFlag()) {
						System.out.println("Enter the second word");
						String lastWord = Utility.isAWord();
						booleanAndString lastWordExistOrNot = dictionary.checkWordExistOrNot(lastWord);
						if (!lastWordExistOrNot.getFlag()) {
							List<BST> sortedWordsFromDictionary = dictionary
									.sortedDictionary(dictionary.rootOfDictionary);
							int startingIndex = 0, lastIndex = 0;
							for (int index = 0; index < sortedWordsFromDictionary.size(); index++) {
								if (sortedWordsFromDictionary.get(index).getKeyString().equals(startingWord)) {
									startingIndex = index;
								}
								if (sortedWordsFromDictionary.get(index).getKeyString().equals(lastWord)) {
									lastIndex = index;
								}
							}
							for (int index = startingIndex; index <= lastIndex; index++) {
								System.out.println(sortedWordsFromDictionary.get(index).toString());
							}
						} else {
							System.out.println("Second word you entered does not exist.");
						}
					} else {
						System.out.println("Word you entered does not exist.");
					}
				} else {
					System.out.println("Dictionary is empty!");
				}
				break;

			case 6:
				System.out.println("Bye! See you later");
				System.exit(0);
				break;
			}

		} while (true);

	}

}
