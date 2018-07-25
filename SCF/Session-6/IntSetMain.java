package Assignment7;

import myUtility.inputValidation;

public class IntSetMain {

	public static void main(String args[]) {

		IntSet setObject = new IntSet();
		do {
			System.out.println("\n1. Find element in set.");
			System.out.println("2. Find size of set.");
			System.out.println("3. Check if a set is subset or not.");
			System.out.println("4. Find complement of set.");
			System.out.println("5. Union of sets.");
			System.out.println("6. Exit.");
			System.out.println("\nPlease select the operation you want ot perform.\n");

			int choice = inputValidation.isIntInRange(1, 6);

			switch (choice) {
			case 1:
				System.out.print("Enter the element you want to find: ");
				int elementToFind = inputValidation.isInt();
				boolean isFound = setObject.isMember(elementToFind);
				if (isFound) {
					System.out.println("\nElement found.\n");
				} else {
					System.out.println("\nElement not found.\n");
				}
				break;

			case 2:
				int lengthOfSet = setObject.size();
				System.out.println("\nLength of set is : " + lengthOfSet);
				break;

			case 3:
				IntSet subSet = new IntSet();
				boolean issubset = setObject.isSubSet(subSet);
				if(issubset){
					System.out.println("Yes, It is subset.");
				}
				else{
					System.out.println("No, It's not subset.");
				}
				break;

			case 4:
				IntSet complementOfSet = setObject.getComplement();
				System.out.println("Complement Set is");
				complementOfSet.Display();
				break;

			case 5:
				IntSet secondSet = new IntSet();
				IntSet union = IntSet.Union(setObject, secondSet);
				union.Display();
				break;

			case 6:
				System.out.println("Bye! See you later.");
				System.exit(0);
				break;
			}
		} while (true);
	}
}