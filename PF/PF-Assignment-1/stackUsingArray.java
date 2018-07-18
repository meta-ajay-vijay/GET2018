/**
 * @(#)stackUsingArray.java
 *
 *
 * @author Ajay Kumar Vijay
 * @version 1.00 2018/7/15
 */
import java.util.*;

public class stackUsingArray 
{
	int topPosition = -1,size; 
	int[] stack;
	
	public stackUsingArray()
	{
	}
    public stackUsingArray(int sizeOfStack) {
    	
    	stack = new int[sizeOfStack];
    	size= sizeOfStack;
    }
    
    public void Push(int itemToBePushed){
    	
    	if(topPosition < size-1)
    		
    		stack[ ++topPosition ] = itemToBePushed;
    	
    	else
    		
    		System.out.println("Stack is Full");
    	
    }
    
    public void Pop(){
    	
    		topPosition--;
    	
    }
    
    public int Top(){
    	
    		return stack[ topPosition ];	
    }
    
    public boolean isEmpty(){
    	
    	if( topPosition == -1){
    		return true;
    	}
    	return false;
    }
    
    public void printStack()
    {
    	for(int i = 0; i <= topPosition; i++)
    	{
    		System.out.print(stack[i]+" ");
    	}
    	System.out.println();
    }
}

class StackOperations extends stackUsingArray{
	
	public static void operationsOnStack(){
    	
    	Scanner scan = new Scanner ( System.in );
    	
    	int stackSize= scan.nextInt();
    	int moreOps; 
    		
    	stackUsingArray stackObject = new stackUsingArray(stackSize);
    	
    	do
    	{
    		System.out.println("1. Push");
    		System.out.println("2. Pop");
    		System.out.println("3. Top");
    		System.out.println("4. isEmpty");
    		System.out.println("5. Print stack");
    		
    		int choice = scan.nextInt();
    		
    		switch (choice) {
    			
    			case 1: 
    				int nextItemInStack = scan.nextInt();
    				stackObject.Push(nextItemInStack);
    				break;
    			
    			case 2: 
    				if( ! stackObject.isEmpty() )
    					stackObject.Pop();
    				break;
    			
    			case 3: 
    				int topElement; 
    				if( ! stackObject.isEmpty() ){
    					topElement = stackObject.Top();
    					System.out.println("Top element: "+ topElement);
    				}
    				break;
    			
    			case 4: 
    				if(stackObject.isEmpty())
    					System.out.println("Stack is empty");
    				else
    					System.out.println("Stack is not empty");
    				break;
    			
    			case 5:
    				 stackObject.printStack();
    				 break;
    			
    			default :
    				System.out.println("Please choose a valid operation");
			}
			
			System.out.println("More Operations?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			
			moreOps = scan.nextInt();
			
    	}while(moreOps != 2);
    	
    }
    
    public static void main(String args[])
    {
    	operationsOnStack();
    }
	
}