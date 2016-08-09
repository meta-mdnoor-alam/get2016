package Session8.BinarySearchTree;

/**
 * Class to implement binary search tree.
 * @author Noor
 */
public class BinarySearchTree {

	private Node root;

	/**
	 * Inner class to create a node with left and right pointing to left-child
	 * and right-child respectively.
	 * @author Noor
	 */
	private class Node {
		private Node left;
		private int data;
		private Node right;

		/**
		 * Parameterized constructor
		 * @param left
		 * @param data
		 * @param right
		 */
		public Node(Node left, int data, Node right) {
			this.left = null;
			this.data = data;
			this.right = null;
		}
	}

	/**
	 * Method to search data item in node recursively.
	 * @param node
	 * @param data
	 * @return
	 */
	private Node searchNode(Node node, int data) {
		if (node == null) {
			return null;
		} else if ((node.data == data)
				|| (node.data > data && node.left == null)
				|| (node.data < data && node.right == null)) {
			return node;
		} else if (node.data > data && node.left != null) {
			return searchNode(node.left, data);
		} else if (node.data < data && node.right != null) {
			return searchNode(node.right, data);
		} else {
			return null;
		}
	}

	/**
	 * Method to insert the node at required position in the tree.
	 * @param data
	 * @return
	 */
	public boolean insert(int data) {
		Node node = new Node(null, data, null);
		if (root == null) {
			root = node;
			return true;
		}
		Node parent = searchNode(root, data);
		if (parent.data > data) {
			parent.left = node;
		} else if (parent.data < data) {
			parent.right = node;
		} else {
			System.out.print("\n\nNode already present.");
			return false;
		}
		return true;
	}

	/**
	 * Method to sort the node data in ascending order by taking inorder of BST.
	 */
	public void sort() {
		if (root == null) {
			System.out.print("\n\nTree is empty. Can't sort empty tree");
			return;
		}
		System.out.print("\n\nSorted tree -->  ");
		inorder(root);
	}

	/**
	 * Method to print the inorder of the tree.
	 * @param node
	 */
	private void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		} else {
			return;
		}
	}
}
