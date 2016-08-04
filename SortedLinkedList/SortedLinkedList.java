package Session5.SortedLinkedList;

/**
 * Class to implement sorted linked list.
 * @author Noor
 */
public class SortedLinkedList {

	private Node start;

	/**
	 * Class to construct a singly linked-list
	 * @author Noor
	 */
	private class Node {
		private int data;
		private Node next;
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Method to perform insertion of data.
	 * @param data
	 */
	public void insert(int data) {
		if (start == null) {
			start = insert(data, start);
		} else {
			if (start.data > data) {
				start = new Node(data, start);
			} else {
				start = insert(data, start);
			}
		}
	}

	/**
	 * Method to insert data at sorted position through recursion.
	 * @param data
	 * @param node
	 * @return node 
	 */
	private Node insert(int data, Node node) {
		if (node == null) {
			Node temp = new Node(data, null);
			return temp;
		} else {
			if (node.data > data && node == start) {
				if (node.next != null) {
					node.next = new Node(data, node.next);
					return node;
				}
			}
			if (node.next != null) {
				if (node.next.data > data) {
					node.next = new Node(data, node.next);
					return node;
				}
			}
			node.next = insert(data, node.next);
			return node;
		}
	}

	/**
	 * Method to show the linked-list
	 */
	public void showLinkedList() {
		if (start == null) {
			System.out.println("\n\nEmpty Linked-List. Nothing to display.");
		} else {
			System.out.println("\n\nSorted Linked-List  :");
			showLinkedList(start);
		}
	}
	
	/**
	 * Method to show the linked-list from specified node.
	 * @param node
	 */
	private void showLinkedList(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.data + "  ");
			showLinkedList(node.next);
		}
	}

	
}
