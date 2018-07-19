package Assignment4;

import java.util.*;
import myUtility.inputValidation;

class OperationString {

	Scanner scan = new Scanner(System.in);
	/**
	 * takes string as input from user
	 * @return inputUser string
	 */
	public String inputString() {

		String inputUser = scan.nextLine();
		inputUser = inputUser.trim();
		if (inputUser.length() == 0) {
			System.out.println("Empty string");
		}
		return inputUser;
	}
	/**
	 * Compare two strings, return true if equal
	 * @param firstString
	 * @param secondString
	 * @return reply
	 */
	public boolean compareTwoStrings(String firstString, String secondString) {
		boolean reply = true;
		if (firstString.length() != secondString.length()) {
			reply = false;
		} else {
			for (int i = 0; i < firstString.length(); i++) {
				if (firstString.charAt(i) != secondString.charAt(i)) {
					reply = false;
					break;
				}
			}
		}
		return reply;
	}

	/**
	 * Reverse the string given in parameters
	 * @param inputString
	 * @return Reversed 
	 */
	public String reverseString(String inputString) {
		String Reversed = new String();
		StringBuilder sb = new StringBuilder(inputString);
		char temp;
		for (int i = 0, j = inputString.length() - 1; i < inputString.length() / 2; i++, j--) {
			temp = sb.charAt(i);
			sb.setCharAt(i, inputString.charAt(j));
			sb.setCharAt(j, temp);
		}
		Reversed = sb.toString();
		return Reversed;
	}

	/**
	 * Convert lower case to upper case and vice versa
	 * @param inputString
	 * @return changedString
	 */
	public String replaceLowerUpperCase(String inputString) {
		int digit = -1;
		String changedString = new String();
		for (int i = 0; i < inputString.length(); i++) {
			digit = (int) inputString.charAt(i);

			if (digit > 64 && digit < 91) {
				digit += 32;
			} else if (digit > 96 && digit < 123) {
				digit -= 32;
			}
			changedString = changedString + (char) digit;
		}
		return changedString;
	}

	/**
	 * Search largest word in given string and return
	 * @param inputString
	 * @return maximumWord
	 */
	public String largestWordInString(String inputString) {
		String maximumWord = "";
		int whitespace = 32;
		int high=0, low=0, max=0;
		for (int i = 0; i < inputString.length(); i++) {
			if(inputString.charAt(i)==' '){
				if((high-low) >=max){
					max= high-low;
					maximumWord= inputString.substring(low, high);
				}
				low = i+1;
			}
			high++;
		}
		if((high-low) >=max){
			max= high-low;
			maximumWord= inputString.substring(low, high);
		}
		return maximumWord;
	}

	/**
	 * Display menu
	 * @param userAction
	 */
	public void operation(int userAction) {
		String firstString = "";
		String secondString = "";
		String resultString = "";
		int result = 0;
		switch (userAction) {
		case 1:
			firstString = inputString();
			secondString = inputString();
			if (compareTwoStrings(firstString, secondString)) {
				System.out.println("Strings are equal");
			} else {
				System.out.println("Strings are not equal");
			}
			break;

		case 2:
			System.out.println("Enter a string");
			firstString = inputString();
			resultString = reverseString(firstString);
			break;

		case 3:
			System.out.println("Enter a string");
			firstString = inputString();
			resultString = replaceLowerUpperCase(firstString);
			break;

		case 4:
			System.out.println("Enter a string");
			firstString = inputString();
			resultString = largestWordInString(firstString);
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Please enter valid input");
		}
		if (userAction > 1)
			System.out.println("" + resultString);

		else
			System.out.println("" + result);

	}

	public static void main(String args[]) {
		OperationString use = new OperationString();
		int userAction;
		do {
			System.out.println("\t 1. Compare Two Strings");
			System.out.println("\t 2. Reverse A String");
			System.out
					.println("\t 3. Replace LowerCase to UpperCase and ViceVersa");
			System.out.println("\t 4. Find Largest Word In A String");
			System.out.println("\t 5. Exit");

			userAction = inputValidation.isInt();

			use.operation(userAction);

		} while (userAction != 5);

	}
}
