package queue;

public class ListNode<T> {
	T data;
	public ListNode<T> next;
	public ListNode<T> previous;

	public ListNode(T data) {
		this.data = data;
		next = null;
		previous = null;
	}
}
