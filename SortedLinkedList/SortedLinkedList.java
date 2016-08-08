package Session5.SortedLinkedList;

import java.util.LinkedList;

/**
 * Class to implement sorted linked list.
 * @author Noor
 */
public class SortedLinkedList {

	private LinkedList<Integer> linkedList;
	
	/**
	 * Default constructor
	 */
	public SortedLinkedList() {
		linkedList = new LinkedList<Integer>();
	}
	
	/**
	 * Method to insert the new element to the list
	 * @param data - The data to be inserted into the list
	 * @return True if the data is inserted to the linked list
	 */
	public boolean insert(int data) {
		int currentIndex = 0;
		if(linkedList.size() == 0) {
			linkedList.add(data);
		} else {
			insert(data, currentIndex);
		}
		return true;
	}
	
	/**
	 * Method to find the correct position to insert the data element.
	 * @param data
	 * @param currentIndex
	 * @return
	 */
	private boolean insert(int data, int currentIndex) {
		
		if(currentIndex >= linkedList.size()) {
			linkedList.addLast(data);
			return true;
		}

		int valueAtCurrentIndex = linkedList.get(currentIndex);
		
		if(valueAtCurrentIndex > data) {
			if(currentIndex == 0) {
				linkedList.addFirst(data);
				return true;
			}
			return false;
		} else {
			if(insert(data, currentIndex+1) == false) {
				linkedList.add(currentIndex+1, data);
			}
		}
		return true;
	}

	/**
	 * Method to show the linked-list
	 */
	public void showLinkedList() {
		int sizeOfLinkedList = linkedList.size();
		if (sizeOfLinkedList == 0) {
			System.out.println("\n\nEmpty Linked-List. Nothing to display.");
		} else {
			System.out.println("\n\nSorted Linked-List  :");
			System.out.println(linkedList);
		}
	}
}
