import Stack.stack;

public class StackArray implements stack{
	
	private int []array;
	private int top=-1;
	private int N;
	
	public StackArray( int N)
	{
		array = new int[N];
		this.N = N;
	}
	

	@Override
	public boolean push(int element) {
		if(top<N)
		{
			array[++top]=element;
			return true;
		}
		else
		{
			System.out.println("The stack is full.");
			return false;
		}
	}

	@Override
	public boolean pop() {
		if(top<=-1)
		{
			System.out.println("The stack is empty.");
			return false;
		}
		else
		{
			top--;
			return true;
		}
	}

	@Override
	public boolean isEmpty() {
		if(top<=-1)
			return true;
		else
			return false;
	}

	@Override
	public int top() {
		return array[top];
	}
}
	
