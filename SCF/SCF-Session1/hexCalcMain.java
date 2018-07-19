package Assignment3.HexaDecimal;
import Assignment3.HexaDecimal.hexCalc;
import java.util.*;
import myUtility.inputValidation;
/**
 * @author ajay
 *
 */
public class hexCalcMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loopFlag=0,choice=0;
		int baseOfNumber;
		do {
			
			System.out.println("1. Add");
			System.out.println("2. Subtract");
    		System.out.println("3. Multiply");
    		System.out.println("4. Division");
    		System.out.println("5. Conversion to Decimal");
    		System.out.println("6. Conversion to Hexadecimal");
    		System.out.println("7. Equal");
    		System.out.println("8. First greater than second");
    		System.out.println("9. First greater than second");
    		System.out.println("10. Exit");
    		
    		choice = inputValidation.isInt();
    		
    		String first,second,result;
    		switch(choice) {
    		case 1:	System.out.print("Enter base: ");
					baseOfNumber = scan.nextInt();
					System.out.print("Enter first hexadecimal number: ");
    				first= inputValidation.isInBase();
    				System.out.print("Enter second hexadecimal number: ");
    				second= inputValidation.isInBase();
    				
    				result = hexCalc.HexAdd(first, second, baseOfNumber);
    				System.out.println("Sum in hexadecimal: "+result);
    			break;
    			
    		case 2: System.out.print("Enter base: ");
					baseOfNumber = scan.nextInt();
    				System.out.print("Enter first hexadecimal number: ");
					first= inputValidation.isInBase();
					System.out.print("Enter second hexadecimal number: ");
					second= inputValidation.isInBase();
					if(hexCalc.smallerThan(second, first)) {
						result = hexCalc.HexSubtract(first, second, baseOfNumber);
						System.out.println("Result: "+result);
					}else {
						System.out.println("Second number is greater than first number.\nSo cannot perform subtract operation.");
					}
					
					
    			break;
    			
    		case 3:	System.out.print("Enter base: ");
					baseOfNumber = scan.nextInt();
    				System.out.print("Enter first hexadecimal number: ");
					first= inputValidation.isInBase();
					System.out.print("Enter second hexadecimal number: ");
					second= inputValidation.isInBase();
					
					result = hexCalc.HexMultiply(first, second, baseOfNumber);
					System.out.println("Result: "+result);
    			break;
    			
    		case 4: 
    				System.out.print("Enter base: ");
					baseOfNumber = scan.nextInt();
    				System.out.print("Enter first hexadecimal number: ");
					first= inputValidation.isInBase();
					System.out.print("Enter second hexadecimal number: ");
					second= inputValidation.isInBase();
					
					result = hexCalc.HexDivide(first, second, baseOfNumber);
					System.out.println("Result: "+result);
    			break;
    			
    		case 5: System.out.print("Enter number base: ");
					baseOfNumber = scan.nextInt();
					System.out.print("Enter number: ");
					first= inputValidation.isInBase();
					int no= hexCalc.BaseToDecimal(first, baseOfNumber);
					System.out.println(no);
    			break;
    			
    		case 6:	System.out.print("Enter base: ");
					baseOfNumber = scan.nextInt();
					System.out.print("Enter number: ");
					int dno= scan.nextInt();
					result = hexCalc.DecToBase(dno, baseOfNumber);
					System.out.println(result);
    			break;
    			
    		case 7:	System.out.print("Enter first hexadecimal number: ");
					first= inputValidation.isInBase();
					System.out.print("Enter second hexadecimal number: ");
					second= inputValidation.isInBase();
					if( hexCalc.isEqual(first, second)) {
						System.out.println("Numbers are equal");
					}
					else{
						System.out.println("Numbers are not equal");
					}
    			break;
    			
    		case 8:	System.out.print("Enter first hexadecimal number: ");
					first= inputValidation.isInBase();
					System.out.print("Enter second hexadecimal number: ");
					second= inputValidation.isInBase();
					if( hexCalc.greaterThan(first, second)) {
						System.out.println("First number is greater than second");
					}
					else{
						System.out.println("First number is not greater than second");
					}
    			break;
    			
    		case 9:	System.out.print("Enter first hexadecimal number: ");
					first= inputValidation.isInBase();
					System.out.print("Enter second hexadecimal number: ");
					second= inputValidation.isInBase();
					if( !hexCalc.greaterThan(first, second)) {
						System.out.println("First number is less than second");
					}
					else{
						System.out.println("First number is not less than second");
					}
    			break;
    			
    		case 10:	loopFlag = 1;
					System.out.println("Bye! See you later.");
    			break;
    			
    		default:
    				System.out.println("Wrong choice.\nPlease enter again.");
    			break;
    		}
    		
		}while(loopFlag == 0);
		
	}

}
