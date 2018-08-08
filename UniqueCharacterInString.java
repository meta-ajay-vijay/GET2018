package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import myUtility.Utility;

public class UniqueCharacterInString {
	Map<String, Integer> cache = new HashMap<String, Integer>();
	Set<String> uniqueCharString = new HashSet<String>();

	private String stringRecieved;

	// Getter START
	public String getStringRecieved() {
		return stringRecieved;
	}

	public void setStringRecieved(String stringRecieved) {
		this.stringRecieved = stringRecieved;
	}

	// Getter END

	/**
	 * count the number of unique characters in string if string is not in cache otherwise take the output from cache 
	 * 
	 * @return the number of unique characters in string
	 */
	public int checkUniqueinStringAndSet() {
		int count;
		if (cache.containsKey(this.stringRecieved)) {
			System.out.println("From cache");
			count = cache.get(this.stringRecieved);
		} else {
			StringBuilder stringBuilderForString = new StringBuilder(this.stringRecieved);
			System.out.println("Output calculated");
			for (int i = 0; i < stringBuilderForString.length(); i++) {
				for (int j = i+1; j < stringBuilderForString.length(); j++) {
					if (stringBuilderForString.charAt(i) == stringBuilderForString.charAt(j)) {
						stringBuilderForString = stringBuilderForString.deleteCharAt(j);
						j--;
					}
				}
			}
			count = stringBuilderForString.length();
			cache.put(this.stringRecieved, count);
		}
		return count;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		UniqueCharacterInString unique = new UniqueCharacterInString();

		System.out.println("How many times you wanna give input?");
		int numberOfInputs = Utility.isPositiveInt();

		for (int i = 0; i < numberOfInputs; i++) {
			System.out.println("\nEnter string");
			unique.setStringRecieved(scan.nextLine());
			int numberofUniqueCharactersInString = unique.checkUniqueinStringAndSet();
			System.out.print("Unique characers in string: " + numberofUniqueCharactersInString);
		}
	}

}
