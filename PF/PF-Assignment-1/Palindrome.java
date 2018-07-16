import java.util.*;

public class Palindrome {
	
	int topPosition = -1,size; 
	char[] stack;
	public Palindrome() {	
	}
	
	public Palindrome(int lengthOfStack) {
		size = lengthOfStack;
		stack = new char[lengthOfStack];
	}
	
	public void Push(char charToInsert)
	{
		if(topPosition < size-1)
    		
    		stack[ ++topPosition ] = charToInsert;
    	
    	else
    		
    		System.out.println("Stack is Full");
	}
	
	public char Pop()
	{
		return stack[ topPosition-- ];
	}
	
	public boolean isEmpty(){
    	
    	if( topPosition == -1){
    		return true;
    	}
    	return false;
    }

	public static void main( String args[] ) {
		Scanner scan = new Scanner ( System.in );
    	
    	String input= scan.nextLine();
		
		Palindrome object1 = new Palindrome( input.length() );
		
		for(int i = 0; i < input.length(); i++)
		{
			object1.Push( input.charAt(i) );
		}
		
		StringBuilder sb = new StringBuilder(new String(""));
		
		for(int i = 0 ; i <= input.length()-1; i--){
			if(!object1.isEmpty())
			sb = sb.append( object1.Pop() );
		}
			
		
		String str = sb.toString();
		if( str.equals(input) )
		{
			System.out.println("String is palindrome");
		}
		else
		{
			System.out.println("String is not palindrome");
		}
	}
}