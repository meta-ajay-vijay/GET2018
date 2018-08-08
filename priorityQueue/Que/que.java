package priorityQueue.Que;

import priorityQueue.priorityElement.PriorityElement;

public interface que {
	public boolean delete();

	public boolean isEmpty();

	public boolean isFull();

	boolean add(PriorityElement element);
}
