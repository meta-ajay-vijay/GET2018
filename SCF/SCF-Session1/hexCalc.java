package Assignment3.HexaDecimal;

/**
 * 
 * @author User6 class for basic mathematics operation on numbers of different
 *         different bases
 */
public class hexCalc {
	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @param base
	 * @return
	 */
	public static String HexAdd(String firstNumber, String secondNumber,
			int base) {
		String first = firstNumber; // Store first number in given base
		String second = secondNumber; // Store second number in given base
		int b = base; // store base
		int f, s, sum; // Store decimal numbers
		f = BaseToDecimal(first, b);
		s = BaseToDecimal(second, b);
		sum = f + s;
		System.out.println("Sum in decimal: " + sum);
		String adding = DecToBase(sum, b);
		return adding;
	}

	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @param base
	 * @return
	 */
	public static String HexSubtract(String firstNumber, String secondNumber,
			int base) {
		String first = firstNumber; // Store first number
		String second = secondNumber; // Store second number
		int b = base; // store base
		int f, s, sub; // Store decimal numbers
		f = BaseToDecimal(first, b);
		s = BaseToDecimal(second, b);
		sub = f - s;
		System.out.println("Sub: " + sub);
		return DecToBase(sub, b);
	}

	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @param base
	 * @return
	 */
	public static String HexMultiply(String firstNumber, String secondNumber,
			int base) {
		String first = firstNumber;
		String second = secondNumber;
		int b = base;
		int f, s, mul;
		f = BaseToDecimal(first, b);
		s = BaseToDecimal(second, b);
		mul = f * s;
		return DecToBase(mul, b);
	}

	/**
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @param base
	 * @return
	 */
	public static String HexDivide(String firstNumber, String secondNumber,
			int base) {
		String first = firstNumber;
		String second = secondNumber;
		int b = base;
		int f, s, div;
		f = BaseToDecimal(first, b);
		s = BaseToDecimal(second, b);
		div = f / s;
		return DecToBase(div, b);
	}

	public static boolean isEqual(String num1, String num2) {
		String first= num1;
		String second= num2;
		first = first.toUpperCase();
		second = second.toUpperCase();
		boolean reply= false;
		if(first.equals(second)){
			reply = true;
		}
		return reply;
	}

	public static boolean greaterThan(String num1, String num2) {
		String first= num1;
		String second= num2;
		first = first.toUpperCase();
		second = second.toUpperCase();
		boolean reply= false;
		if( first.length() > second.length() ){
			reply = true;
		}
		else if(first.length() < second.length()) {
			reply = false;
		}
		else {
				for(int i=0 ; i<first.length(); i++){
					if( first.charAt(i) > second.charAt(i) ){
						reply = true;
						break;
					}
					else if(first.charAt(i) <= second.charAt(i) ){
						reply= false;
						break;
					}
						
				}
		}
		return reply;
	}
	
	public static boolean smallerThan(String num1, String num2) {
		String first= num1;
		String second= num2;
		first = first.toUpperCase();
		second = second.toUpperCase();
		boolean reply= false;
		if( first.length() < second.length() ){
			reply = true;
		}
		else if(first.length() > second.length()) {
			reply = false;
		}
		else {
			for(int i=0; i<first.length(); i++){
				if( first.charAt(i) < second.charAt(i) ){
					reply = true;
					break;
				}
				else if(first.charAt(i) >= second.charAt(i) ){
					reply= false;
					break;
				}
			}
			
		}
		return reply;
	}


	/**
	 * converts number from given base to base 10.
	 * 
	 * @param HexNumber
	 * @param base
	 * @return Decimal number
	 */
	public static int BaseToDecimal(String HexNumber, int base) {
		int decNumber = 0, b = base;
		String hex = HexNumber;
		for (int index = hex.length() - 1, power = 0; index >= 0; index--, power++) {
			char c = hex.charAt(index);
			if ((c >= 'A' && c <= 'F') || (c >= 'a' || c >= 'f')) {
				c = Character.toUpperCase(c);
				int temp1 = AfterNine(c);
				decNumber += (int) Math.pow(b, power) * temp1;
			}
			if (c >= '0' && c <= '9') {
				int temp1 = Character.getNumericValue(c);
				decNumber += (int) Math.pow(b, power) * temp1;
			}

		}
		return decNumber;
	}

	/**
	 * converts decimal number into given base
	 * 
	 * @param DecimalNumber
	 * @param base
	 * @return
	 */
	public static String DecToBase(int DecimalNumber, int base) {

		int number = DecimalNumber, b = base, remainder;
		String inBase = new String();
		StringBuilder sb = new StringBuilder(inBase);

		if (base >= 2 && base < 10) {
			while (number > 0) {
				remainder = number % b;
				sb = sb.append(remainder);
				number /= b;
			}
		} else if (base > 10 && base <= 16) {
			while (number > 0) {
				remainder = number % b;
				char rem = AfterNineBase(remainder);
				sb = sb.append(rem);
				number /= b;
			}
		}
		sb = sb.reverse();
		inBase = sb.toString();
		return inBase;
	}

	public static int AfterNine(char c) {
		int digit = -1;
		switch (c) {
		case 'A':
			digit = 10;
			break;

		case 'B':
			digit = 11;
			break;

		case 'C':
			digit = 12;
			break;

		case 'D':
			digit = 13;
			break;

		case 'E':
			digit = 14;
			break;

		case 'F':
			digit = 15;
			break;
		}
		return digit;
	}

	public static char AfterNineBase(int number) {
		char digit = ' ';
		switch (number) {
		case 10:
			digit = 'A';
			break;

		case 11:
			digit = 'B';
			break;

		case 12:
			digit = 'C';
			break;

		case 13:
			digit = 'D';
			break;

		case 14:
			digit = 'E';
			break;

		case 15:
			digit = 'F';
			break;

		default:
			digit = new Integer(number).toString().charAt(0);
		}
		return digit;
	}

	public static void main(String args[]) {

	}

}