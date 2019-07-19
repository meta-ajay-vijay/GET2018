package stringoperation;

import java.util.*;

public class Strings {

	public static void main(String[] args) {
		try {
			while (true) {
				String firstString = "";
				String secondString = "";
				String value = "";
				Scanner input = new Scanner(System.in);
				Operation object = new Operation();
				System.out.println("Enter the choice for String operation ");
				System.out.println("Enter 1 for comparing two String  ");
				System.out.println("Enter 2 for reversing two String ");
				System.out.println("Enter 3 for changing the case of String ");
				System.out.println("Enter 4 for finding the largest String ");
				System.out.println("Enter 5 for Exit ");
				int choice = input.nextInt();
				input.nextLine(); // to ignoring enter value
				switch (choice) {
				case 1:
					System.out.println("Enter the first String");
					firstString = input.nextLine();
					System.out.println("Enter the second String");
					secondString = input.nextLine();
					if (object.stringCompare(firstString, secondString) == 1) {
						System.out.println("The entered Strings are equal");
					} else {
						System.out.println("The entered Strings are not equal");
					}
					break;
				case 2:
					System.out.println("Enter the String to be reversed");
					value = input.nextLine();
					System.out.println(object.reverseOfString(value));
					break;
				case 3:
					System.out.println("Enter the String whose case is to be changed from lowercase to uppercase and vice-versa");
					value = input.nextLine();
					System.out.println(object.changeCase(value));
					break;
				case 4:
					System.out.println("Enter the String for finding the largest String");
					value = input.nextLine();
					System.out.println(object.largestString(value));
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Please choose the correct options only!! ");
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid entry...");
			main(args);
		}
	}
}
