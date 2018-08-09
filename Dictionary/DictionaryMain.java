/**
 * 
 */
package Dictionary;

import java.util.Scanner;

/**
 * @author User1
 *
 */
public class DictionaryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choice;
		DictionaryClass dictionary = new DictionaryClass();

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
				booleanAndString checkResultOfInsertion = dictionary.checkWordExistOrNot(wordToAddInDictionary);

				if (checkResultOfInsertion.getFlag()) {
					dictionary.addInDictionary(wordToAddInDictionary);
					System.out.println(checkResultOfInsertion.getMessage());
				} else {
					System.out.println(checkResultOfInsertion.getMessage());
				}

				break;

			case 2:

				break;

			case 3:
				System.out.println("Enter the word");
				String wordWhichMeaningUserWantToKnow = Utility.isAWord();
				
				booleanAndString result = dictionary.getValueFromDictionary(wordWhichMeaningUserWantToKnow);
				if(result.getFlag()) {
					System.out.println("Meaning of word is");
					System.out.println(result.getMessage());
				} else {
					System.out.println(result.getMessage());
				}
				
				break;

			case 4:

				break;

			case 5:

				break;

			case 6:
				System.exit(0);
				System.out.println("Bye! See you later");
				break;
			}

		} while (true);

	}

}
