package priorityQueue;

import priorityQueue.Que.que;
import priorityQueue.priorityElement.PriorityElement;

public class QueArray implements que {
	private PriorityElement[] array;
	private int back = -1;
	private int sizeOfQueue;

	public QueArray(int sizeOfQueue) {
		array = new PriorityElement[sizeOfQueue];
		this.sizeOfQueue = sizeOfQueue;
	}

	@Override
	public boolean add(PriorityElement element) {
		if (this.isFull()) {
			System.out.println("The Que is Full.");
			return false;
		} else {
			array[++back] = element;
			return true;
		}
	}

	@Override
	public boolean delete() {
		if (this.isEmpty()) {
			System.out.println("The Que is Empty");
			return false;

		} else if (back == 0) {
			array[0] = null;
			back = -1;
			return true;
		} else {
			array[0] = null;
			for (int i = 0; i < back; i++) {
				array[i] = array[i + 1];
			}
			back--;
			return true;
		}
	}

	@Override
	public boolean isEmpty() {
		if (back < 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (back >= sizeOfQueue) {
			return true;
		}
		return false;
	}

	public boolean deleteHighestPriorityElement() {
		int maxPriority = findHighestPriority();
		for (int i = 0; i <= back; i++) {
			if (array[i].getPriority() == maxPriority) {
				if (i < back) {
					for (; i < back; i++) {
						array[i] = array[i + 1];
					}
				} else {
					array[back] = null;
				}
				back--;
				return true;
			}
		}
		return false;
	}

	private int findHighestPriority() {
		int max = 0;
		for (int i = 0; i <= back; i++) {
			if (array[i].getPriority() > max) {
				max = array[i].getPriority();
			}
		}
		return max;
	}

	public void displayQue() {
		for (int i = 0; i <= back; i++) {
			System.out.println(" Element :" + array[i].getData() + " Priority :" + array[i].getPriority());
		}
	}

}