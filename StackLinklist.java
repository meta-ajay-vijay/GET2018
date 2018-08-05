package DSASession2Part1.InfixToPostfix.stack;

import DSASession2Part1.InfixToPostfix.operators.OperatorEnum;

public class StackLinklist<T> implements Stack<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	int size = 0;

/**
 * pushing element to stack	
 */
	@Override
	public boolean push(T element) {
		ListNode<T> temp = new ListNode<T>(element);
		if (isEmpty()) {
			setHead(temp);
			setTail(temp);
		} else {
			getTail().next = temp;
			temp.previous = getTail();
			setTail(temp);
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
				setTail(null);
				setHead(null);
				size--;
				flag = true;
			} else {

				setTail(getTail().previous);
				getTail().next = null;
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

			return (T) getTail().data;
		}
		return null;
	}

/**
 * true if stack is empty	
 */
	@Override
	public boolean isEmpty() {
		return ((getHead() == null) && (getTail() == null)) ? true : false;
	}

/**
 * returns the array of current stack	
 */
	@Override
	public T[] getStack() {
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			T[] array = (T[]) new Object[size];
			ListNode<T> temp = getTail();
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
public T peek() {
	if(getTail()!= null && getHead()!= null)
		return  getTail().data;
	return null;
}
public ListNode<T> getHead() {
	return head;
}
public void setHead(ListNode<T> head) {
	this.head = head;
}
public ListNode<T> getTail() {
	return tail;
}
public void setTail(ListNode<T> tail) {
	this.tail = tail;
}


}
