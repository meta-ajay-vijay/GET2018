package priorityQueue.priorityElement;

public class PriorityElement<T> {
	private T data;
	private int priority;

	public PriorityElement(T data, int priority) {
		this.data = data;
		this.priority = priority;
	}

	@SuppressWarnings("unchecked")
	public PriorityElement(T obj) {
		this.data = (T) ((PriorityElement<Object>) obj).getData();
		this.priority = ((PriorityElement<Object>) obj).getPriority();
	}

	public T getData() {
		return data;
	}

	public int getPriority() {
		return priority;
	}

}
