package Assignment6.LinearBinary;

import java.util.Scanner;

import myUtility.inputValidation;

class SearchMain{
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int choice, size, elementToSearch, indexPosition;
		int[] inputArray;
		do {
			
			System.out.println("Enter the index of operation you want to perform: ");
			System.out.println("1. Linear Search");
			System.out.println("2. Binary Search");
			System.out.println("3. Exit");
			choice = inputValidation.isIntInRange(1,3);
			
			
			switch(choice) {
			case 1:	
				System.out.print("Enter the size of array: ");
				size = inputValidation.isPositiveInt();
				inputArray = new int[size];
				
				System.out.println("Enter the elements of array");
				for(int i=0; i<size; i++) {
					inputArray[i] = inputValidation.isInt();
				}
				
				System.out.print("Enter the element you want to search: ");
				elementToSearch = inputValidation.isInt(); 
				
				indexPosition = Search.LinearSearch(inputArray, elementToSearch, 0);
				if(indexPosition != -1) {
					System.out.println("Element "+elementToSearch+" is found at "+(indexPosition+1)+" position.");
				}
				else {
					System.out.println("Element is not found.");
				}
				
				break;
				
			case 2:
				System.out.print("Enter the size of array: ");
				size = inputValidation.isPositiveInt();
				inputArray = new int[size];
				
				System.out.println("Enter the sorted array");
				for(int i=0; i<size; i++) {
					inputArray[i] = inputValidation.isInt();
				}
				
				System.out.print("Enter the element you want to search: ");
				elementToSearch = inputValidation.isInt(); 
				int start=0, end=size-1/*, mid= (start+end)/2*/;
				indexPosition = Search.BinarySearch(inputArray, elementToSearch, start/*, mid*/, end);
				if(indexPosition != -1) {
					System.out.println("Element "+elementToSearch+" is found at "+(indexPosition+1)+" position.");
				}
				else {
					System.out.println("Element is not found.");
				}
				break;
				
			case 3:
				System.out.println("Bye! See you later");
				System.exit(0);
				break;
				
			default:
				break;
			
			}
			
		}while(choice != 3);
	}
}