package Assignment6.LCMHCF;

import java.util.Scanner;

import myUtility.inputValidation;

public class LcmHcfMain {
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		int choice;
		do{
			System.out.println("\tSelect an operation you want to perform");
			System.out.println("1. HCF of two numbers");
			System.out.println("2. LCM of two numbers");
			System.out.println("3. Exit");
			
			choice = inputValidation.isIntInRange(1, 3);
			int first, second, result;
			System.out.println("Enter first number");
			first = inputValidation.isInt();
			System.out.println("Enter second number");
			second = inputValidation.isInt();
			if(first < second)
			{
				int temporary = first;
				first = second;
				second = temporary;
			}
			switch(choice){
			case 1:
				result = LcmHcf.calculateHcf(first, second);
				System.out.println("HCF is "+result);
				break;
			case 2:
				
				result = LcmHcf.calculateLcm(first, second, 2);
				System.out.println("LCM is "+result);
				break;
				
			case 3:
				System.exit(0);
				break;
				
			default:
				break;
			}
			
		}while(choice!=3);
	}
	
}