package stack;

public class StackLinklist<T> implements Stack<T> {
	ListNode<T> head;
	ListNode<T> tail;
	int size = 0;

/**
 * pushing element to stack	
 */
	@Override
	public boolean push(T element) {
		ListNode<T> temp = new ListNode<T>(element);
		if (isEmpty()) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			temp.previous = tail;
			tail = temp;
		}
		size++;
		return true;
	}
/**
 * removing element from stack
 */
	@Override
	public boolean pop() {
		boolean flag = false;
		if (!isEmpty()) {
			if (size == 1) {
				tail = null;
				head = null;
				size--;
				flag = true;
			} else {

				tail = tail.previous;
				tail.next = null;
				flag = true;
				size--;
			}
		}
		return flag;
	}

/**
 * returns the top most element of stack	
 */
	@Override
	public T top() {
		if (!isEmpty()) {

			return (T) tail.data;
		}
		return null;
	}

/**
 * true if stack is empty	
 */
	@Override
	public boolean isEmpty() {
		return ((head == null) && (tail == null)) ? true : false;
	}

/**
 * returns the array of current stack	
 */
	@Override
	public T[] getStack() {
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			T[] array = (T[]) new Object[size];
			ListNode<T> temp = tail;
			int i = 0;
			while (temp != null) {
				array[i] = (T) temp.data;
				i++;
				temp = temp.previous;
			}
			return array;
		} else {
			return null;
		}
	}

}
