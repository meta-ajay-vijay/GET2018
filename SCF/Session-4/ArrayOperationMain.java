package Assignment5;
import java.util.Scanner;

import myUtility.inputValidation;

public class ArrayOperationMain{
	Scanner scan = new Scanner(System.in);
	public static void main(String args[]) {
		ArrOperation obj = new ArrOperation();
		int choice,result;
		int[] resultArray;
		do{
			System.out.println("\tSelect an operation you want to perform");
			System.out.println("1. Find size of longest mirror");
			System.out.println("2. Number of clumps");
			System.out.println("3. Fix XY problem");
			System.out.println("4. Split array");
			System.out.println("5. Exit.");
			
			choice = inputValidation.isIntInRange(1, 5);
			int size;
			System.out.println("Enter size of array");
			size = inputValidation.isPositiveInt();
			int[] inputArray = new int[size];
			System.out.println("Enter array");
			for(int i=0; i < size; i++){
				inputArray[i] = inputValidation.isInt();
			}
			
			switch(choice){
			case 1:
				result = obj.mirrorSection(inputArray);
				System.out.println(result);
				break;
				
			case 2:
				result = obj.clumpsOfArray(inputArray);
				System.out.println(result);
				break;
				
			case 3:
				int first,second;
				System.out.print("Enter first value: ");
				first = inputValidation.isInt();
				System.out.print("Enter second value: ");
				second = inputValidation.isInt();
				resultArray = obj.fixXY(inputArray, first, second);
				break;
				
			case 4:
				result = obj.splitArray(inputArray);
				System.out.println(result);
				break;
				
			case 5:
				System.exit(0);
				break;
			}
			
		}while(choice!=5);

	}
}