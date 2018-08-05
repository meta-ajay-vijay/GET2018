package DSASession2Part1.InfixToPostfix.stack;



public interface Stack<T> {
	public boolean push(T element);

	public boolean pop();

	public T top();

	public boolean isEmpty();
	
	public T[] getStack();
}
