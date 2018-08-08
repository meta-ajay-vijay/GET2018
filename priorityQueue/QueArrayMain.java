package priorityQueue;

import java.util.Scanner;

import priorityQueue.InputOutput.InputValidate;
import priorityQueue.priorityElement.PriorityElement;

public class QueArrayMain {
	QueArray Queue;

	/*
	 * method creates an object to insert in priority queue
	 */
	public boolean createElementAndEnterInQue() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the element");
		String data = scan.nextLine();
		System.out.println("Enter the priority of the Element");
		int priorityOfElement = InputValidate.isInt();
		PriorityElement element = new PriorityElement(data, priorityOfElement);
		return Queue.add(element);
	}

	public void displayQue() {
		Queue.displayQue();
	}

	public boolean deleteHighestPriorityElement() {
		return Queue.deleteHighestPriorityElement();
	}

	public static void main(String args[]) {
		QueArrayMain obj = new QueArrayMain();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size");
		int N = InputValidate.isPositiveInt();
		obj.Queue = new QueArray(N);
		for (int index = 0; index < N; index++) {
			obj.createElementAndEnterInQue();
		}
		System.out.println("Priority Queue is");
		obj.displayQue();
		obj.deleteHighestPriorityElement();
		System.out.println("After deleting element with highest priority, Priority Queue is");
		obj.displayQue();

	}
}
