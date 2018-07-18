/**
 * @(#)stackUsingLinkedList.java
 *
 *
 * @author Ajay Kumar Vijay
 * @version 1.00 2018/7/15
 */
import java.util.*;

public class stackUsingLinkedList {

    private stackNode top;
    int size;
    
    public stackUsingLinkedList()
    {
    	size = 0;
    	top = null;
    }
    
    class stackNode
    {
    	private int data;
    	private stackNode next;
    	
    	public stackNode(int data)
    	{
    		this.data = data;
    		this.next = null;
    	}
    }
    
    public void Push(int itemToBePushed)
    {
    	stackNode newNode = new stackNode(itemToBePushed);
    	if( size == 0 )
    	{
    		top = newNode;
    		size++;
    	}
    	else
    	{
    		newNode.next = top;
    		top = newNode;
    		size++;
    	}
    }
    
    public void Pop()
    {
    	if( size != 0 )
    	{
    		top = top.next;
    		size--;
    	}
    	else
    		System.out.println("Stack is empty");
    }
    
    public void Top()
    {
    	if( size == 0 )
    	{
    		System.out.println("Stack is empty");
    	}
    	else
    	{
    		System.out.println(top.data);
    	}
    }
    
    public boolean isEmpty()
    {
    	if( size == 0 )
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public void printStack()
    {
    	if( size == 0 )
    	{
    		System.out.println("Stack is empty");
    	}
    	else
    	{
    		stackNode currentNode = top;
    		while( currentNode != null )
    		{
    			System.out.print(currentNode.data+" ");
    			currentNode = currentNode.next;
    		}
    	}
    }
    
    
    public static void main(String args[])
    {
    	Scanner scan = new Scanner( System.in );
    	
    	stackUsingLinkedList stackObject = new stackUsingLinkedList();
    	
    	int moreOps;
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
    				 
    				if( ! stackObject.isEmpty() )
    					stackObject.Top();
    			
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
    
}