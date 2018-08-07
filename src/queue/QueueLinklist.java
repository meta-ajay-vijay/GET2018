package queue;

import queue.ListNode;

public class QueueLinklist<T> implements Queue<T> {
	ListNode<T> head;
	ListNode<T> tail;
	int size=0;

/**
 * inserting an element to queue	
 */
	@Override
	public boolean enqueue(T element) {
		boolean flag = false;
		ListNode<T> temp = new ListNode<T>(element);
		if(!isEmpty()){
			tail.next = temp;
			temp.previous = tail;
			tail= temp;
			size++;
			flag = true;
		}else{
			head= temp;
			tail = temp;
			size++;
			flag = true;

		}
		return flag;
	}
/**
 * deleting element from queue
 */
	@Override
	public boolean dequeue () {
		boolean flag = false;
		if (!isEmpty()) {
			if (size == 1) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.previous = null;
			}
			size--;
			flag = true;
		}
		return flag;
	}
/**
 * returns the first element o queue	
 */
	@Override
	public T peek() {
		if(!isEmpty()){
		return (T)head.data;
		}else{
			return null;
		}
	}
/**
 * returns true if queue is empty	
 */
	@Override
	public boolean isEmpty() {
		return ((head == null) && (tail == null)) ? true : false;
	}

/**
 * returns the array of queue	
 */
	@Override
	public T[] getQueue() {
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			T[] array = (T[]) new Object[size];
			ListNode<T> temp = head;
			int i = 0;
			while (temp != null) {
				array[i] = (T) temp.data;
				i++;
				temp = temp.next;
			}
			return array;
		} else {
			return null;
		}
	}
	
}
