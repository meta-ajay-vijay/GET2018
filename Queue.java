package queue;

public interface Queue<T>{
	public boolean enqueue(T element);

	public boolean dequeue();

	public T peek();

	public boolean isEmpty();
	
	public T[] getQueue();
}
