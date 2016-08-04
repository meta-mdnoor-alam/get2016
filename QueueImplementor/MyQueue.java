package Session5.QueueImplementor;

import java.util.LinkedList;

/**
 * Program to implement queue functionality using Linked-List
 * @author Noor
 */
public class MyQueue {

	LinkedList<Integer> queue;

	/**
	 * Default constructor
	 */
	public MyQueue() {
		queue = new LinkedList<Integer>();
	}
	
	/**
	 * Method to add an element data in queue.
	 * @param data
	 * @return success
	 */
	public boolean enqueue(int data) {
		int nextIndex = queue.size();
		queue.add(nextIndex, data);
		return true;
	}

	/**
	 * Method to delete an element from the queue.
	 * @return deleted value.
	 */
	public int dequeue() {
		if (queue.size() == 0) {
			return -111111;
		} else {
			return queue.remove(0);
		}
	}

	/**
	 * Method to display the queue.
	 */
	public void displayQueue() {
		if (queue.size()==0) {
			System.out.print("Queue is Empty. Nothing to show.\n");
			return;
		}
		System.out.print("\nQueue  :\n\nFRONT--> ");
		for (int data : queue) {
			System.out.print(data + " ");
		}
		System.out.println("<--REAR");
	}
}
